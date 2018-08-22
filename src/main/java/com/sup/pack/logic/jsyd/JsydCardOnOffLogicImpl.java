package com.sup.pack.logic.jsyd;

import com.sup.pack.constant.ProcessAction;
import com.sup.pack.dto.SupplierReqData;
import com.sup.pack.logic.BaseLogic;
import com.sup.pack.logic.jsyd.dto.CardSwitchData;
import com.sup.pack.logic.jsyd.dto.RequestHeader;
import com.sup.pack.logic.jsyd.util.JsydHttpClient;
import com.sup.pack.util.JaxbUtil;
import com.sup.pack.util.JsonHelper;
import com.sup.pack.util.SeqIdGenerator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lianzf
 * @Description:江苏移动流量卡停复机操作接口,最终操作结果需要调用JsydResultSearchLogicImpl进行获取
 * @date 18/5/3上午9:59
 */
@Service
public class JsydCardOnOffLogicImpl implements BaseLogic {
    private static final Logger logger = LoggerFactory.getLogger(JsydCardOnOffLogicImpl.class);

    @Autowired
    JsydResultSearchLogicImpl jsydResultSearchLogicImpl;

    @Override
    public Map<String, String> deal(SupplierReqData supplierReqData) throws Exception {
        Map<String, String> resultMap = new HashMap<String, String>();
        resultMap.put("result", "fail");
        try {
            String action = supplierReqData.getAction();//传进来的执行动作(停机|复机)
            String groupId = JsonHelper.toMap(supplierReqData.getEcExtensionInfo()).get("groupId").toString();
            String appId = JsonHelper.toMap(supplierReqData.getEcExtensionInfo()).get("appId").toString();
            String tokenSign = supplierReqData.getInvokeToken();
            String interfaceTag = supplierReqData.getInterfaceInfo();
            RequestHeader header = new RequestHeader();
            header.setAppId(appId);
            header.setAccessToken(tokenSign);
            header.setReqType(2);
            header.setProcessCode(interfaceTag);
            header.setReqSeq(SeqIdGenerator.createJsydReqSeq());
            CardSwitchData data = new CardSwitchData();
            data.setGroupId(groupId);
            data.setTelnum(supplierReqData.getMsisdn());
            String opertype = ProcessAction.CARD_OPEN.equals(action) ? "2" : "1";
            data.setOprtype(opertype);
            data.setReason(opertype.equals("2") ? "7" : "6");//7复机,6其他情况下停机
            header.setContent(data);
            String formData = JaxbUtil.convertToXml(header);
            String url = supplierReqData.getUrl();
            logger.info("江苏移动流量卡停复机请求: {}, 报文: {}", url, formData);
            String result = JsydHttpClient.postRequest(url, formData);
            if (StringUtils.isNotBlank(result)) {
                logger.info("江苏移动流量卡停复机响应: {}", result);
                result = JsonHelper.xml2json(result);
                Map<String, Object> resultMap1 = JsonHelper.toMap(result);
                String resp_code = (String) ((Map) resultMap1.get("response")).get("resp_code");
                if ("0000".equals(resp_code)) {
                    Map<String, Object> contentMap = (Map<String, Object>) resultMap1.get("content");
                    String ret_code = (String) contentMap.get("ret_code");
                    if ("0".equals(ret_code)) {
                        //TODO 代表请求成功，后续步骤之后补齐
                        resultMap.put("result", "success");
                    }
                }else if(result.contains("停机状态的用户不允许再停机")){
                    resultMap.put("result", "success");
                }else{
                    String resultDesc = (String) ((Map) resultMap1.get("response")).get("resp_desc");
                    resultMap.put("resultDesc", resultDesc);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("上游卡停复机错误: " + e);
        }
        return resultMap;
    }
}
