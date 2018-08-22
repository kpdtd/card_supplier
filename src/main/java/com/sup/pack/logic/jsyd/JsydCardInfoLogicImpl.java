package com.sup.pack.logic.jsyd;


import com.sup.pack.dto.CardInfoData;
import com.sup.pack.dto.SupplierReqData;
import com.sup.pack.logic.BaseLogic;
import com.sup.pack.logic.jsyd.dto.CardInfoRequestData;
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
 * @Description:江苏移动卡信息查询接口
 * @date 18/4/15下午2:47
 */
@Service
public class JsydCardInfoLogicImpl implements BaseLogic {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(JsydCardInfoLogicImpl.class);

    @Override
    public CardInfoData deal(SupplierReqData supplierReqData) {
        try {
            String appId = JsonHelper.toMap(supplierReqData.getEcExtensionInfo()).get("appId").toString();
            String tokenSign = supplierReqData.getInvokeToken();
            String interfaceTag = supplierReqData.getInterfaceInfo();
            RequestHeader header = new RequestHeader();
            header.setAppId(appId);
            header.setAccessToken(tokenSign);
            header.setProcessCode(interfaceTag);
            header.setReqSeq(SeqIdGenerator.createJsydReqSeq());
            CardInfoRequestData data = new CardInfoRequestData();
            data.setMsisdn(supplierReqData.getMsisdn());
            data.setDdrCity("22");// TODO 暂不知道如何获取 目前只有盐城一个地方的地区，没有获取地区的方式，只能写死
            header.setContent(data);
            String formData = JaxbUtil.convertToXml(header);
            String url = supplierReqData.getUrl();
            logger.info("江苏移动卡信息查询请求: {}, 报文: {}", url, formData);
            String result = JsydHttpClient.postRequest(url, formData);
            if (StringUtils.isNotBlank(result)) {
                logger.info("江苏移动卡信息查询响应: {}", result);
                result = JsonHelper.xml2json(result);
                Map<String,Object> resultMap = JsonHelper.toMap(result);
                String resp_code = (String) ((Map)resultMap.get("response")).get("resp_code");
                if("0000".equals(resp_code)) {
                    Map<String, Object> contentMap = (Map<String, Object>) resultMap.get("content");
                    CardInfoData cardInfoData = new CardInfoData();
                    cardInfoData.setMsisdn(supplierReqData.getMsisdn());
                    String imsi = contentMap.get("imsi") != null ? contentMap.get("imsi").toString(): null;
                    String iccid = contentMap.get("iccid") != null ? contentMap.get("iccid").toString(): null;
                    cardInfoData.setImsi(imsi);
                    cardInfoData.setIccid(iccid);
                    return cardInfoData;
                }
            }
        }catch(Exception e){
            logger.error("江苏移动卡信息查询错误: " + e);
            e.printStackTrace();
        }
        return null;
    }
}
