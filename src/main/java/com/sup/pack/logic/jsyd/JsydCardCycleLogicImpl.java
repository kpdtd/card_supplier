package com.sup.pack.logic.jsyd;

import com.sup.pack.dto.CardInfoData;
import com.sup.pack.dto.SupplierReqData;
import com.sup.pack.logic.BaseLogic;
import com.sup.pack.logic.jsyd.dto.CardCycleData;
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
 * @Description:生命周期查询接口
 * @date 18/5/8上午9:55
 */
@Service
public class JsydCardCycleLogicImpl implements BaseLogic {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(JsydCardCycleLogicImpl.class);
    @Override
    public CardInfoData deal(SupplierReqData supplierReqData) throws Exception {
        CardInfoData cardInfoData=new CardInfoData();
        String appId = JsonHelper.toMap(supplierReqData.getEcExtensionInfo()).get("appId").toString();
        String tokenSign = supplierReqData.getInvokeToken();
        String interfaceTag = supplierReqData.getInterfaceInfo();
        RequestHeader header = new RequestHeader();
        header.setAppId(appId);
        header.setAccessToken(tokenSign);
        header.setReqType(1);
        header.setProcessCode(interfaceTag);
        header.setReqSeq(SeqIdGenerator.createJsydReqSeq());
        CardCycleData data = new CardCycleData();
        data.setTelnum(supplierReqData.getMsisdn());
        header.setContent(data);
        String formData = JaxbUtil.convertToXml(header);
        logger.info("江苏移动卡生命周期请求URL: {}, 报文: {}",supplierReqData.getUrl(),formData);
        String response = JsydHttpClient.postRequest(supplierReqData.getUrl(), formData);
        logger.info("江苏移动卡生命周期响应报文："+response);
        if (StringUtils.isNotBlank(response)) {
            response = JsonHelper.xml2json(response);
            Map<String,Object> resultMap = JsonHelper.toMap(response);
            String resp_code = (String) ((Map)resultMap.get("response")).get("resp_code");
            if("0000".equals(resp_code)) {
                String ret_code = (String) ((Map)resultMap.get("content")).get("ret_code");
                if("0".equals(ret_code)) {
                    Map<String, Object> contentMap = (Map<String, Object>) resultMap.get("content");
                    String cycle = (String) contentMap.get("cycle");
                    if("1".equals(cycle)){
                        cardInfoData.setCardState(1);
                    }else if("2".equals(cycle)){
                        cardInfoData.setCardState(2);
                    }else if("3".equals(cycle)){
                        cardInfoData.setCardState(3);
                    }else{
                        cardInfoData.setCardState(99); // TODO 未知状态，不与操作
                    }
                    cardInfoData.setIccid(supplierReqData.getIccid());
                    cardInfoData.setMsisdn(supplierReqData.getMsisdn());
                    cardInfoData.setImsi(supplierReqData.getImsi());
                    return cardInfoData;
                }
            }
        }
        return null;
    }
}
