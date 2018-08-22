package com.sup.pack.logic.jsyd;

import com.sup.pack.dto.SupplierReqData;
import com.sup.pack.logic.BaseLogic;
import com.sup.pack.logic.jsyd.dto.CardTestEndData;
import com.sup.pack.logic.jsyd.dto.RequestHeader;
import com.sup.pack.logic.jsyd.util.JsydHttpClient;
import com.sup.pack.util.JaxbUtil;
import com.sup.pack.util.JsonHelper;
import com.sup.pack.util.SeqIdGenerator;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author lianzf
 * @Description:江苏移动卡沉默期强制激活
 * @date 18/5/3上午10:01
 */
@Service
public class JsydCardFinishActiveLogicImpl implements BaseLogic {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(JsydCardFinishActiveLogicImpl.class);
    @Override
    public Boolean deal(SupplierReqData supplierReqData) throws Exception {
        try {
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
            CardTestEndData data = new CardTestEndData();
            data.setGroupId(groupId);
            data.setTelnum(supplierReqData.getMsisdn());
            header.setContent(data);
            String formData = JaxbUtil.convertToXml(header);
            String url = supplierReqData.getUrl();
            logger.info("沉默期截止请求: {}, 报文: {}", url, formData);
            String result = JsydHttpClient.postRequest(url, formData);
            if (StringUtils.isNotBlank(result)) {
                logger.info("沉默期截止响应: {}", result);
                result = JsonHelper.xml2json(result);
                Map<String,Object> resultMap = JsonHelper.toMap(result);
                String resp_code = (String) ((Map)resultMap.get("response")).get("resp_code");
                if("0000".equals(resp_code)) {
                    Map<String, Object> contentMap = (Map<String, Object>) resultMap.get("content");
                    String ret_code = (String) contentMap.get("ret_code");
                    if("0".equals(ret_code)){
                        //TODO 代表请求成功，后续步骤之后补齐
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            logger.error("上游沉默期截止错误: " + e);
            e.printStackTrace();
        }
        return false;
    }
}
