package com.sup.pack.logic.jsyd;

import com.sup.pack.dto.SupplierReqData;
import com.sup.pack.logic.BaseLogic;
import com.sup.pack.logic.jsyd.dto.RequestHeader;
import com.sup.pack.logic.jsyd.dto.ResultData;
import com.sup.pack.logic.jsyd.util.JsydHttpClient;
import com.sup.pack.util.JaxbUtil;
import com.sup.pack.util.JsonHelper;
import com.sup.pack.util.SeqIdGenerator;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author lianzf
 * @Description:江苏移动受理类的接口最终的受理结果查询
 * @date 18/5/8上午11:23
 */
@Service
public class JsydResultSearchLogicImpl implements BaseLogic {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(JsydResultSearchLogicImpl.class);
    @Override
    public Object deal(SupplierReqData supplierReqData) throws Exception {
        String orderId = supplierReqData.getSeqId();
        String appId = JsonHelper.toMap(supplierReqData.getEcExtensionInfo()).get("appId").toString();
        String tokenSign = supplierReqData.getInvokeToken();
        String interfaceTag = supplierReqData.getInterfaceInfo();
        RequestHeader header = new RequestHeader();
        header.setAppId(appId);
        header.setAccessToken(tokenSign);
        header.setReqType(2);
        header.setProcessCode(interfaceTag);
        header.setReqSeq(SeqIdGenerator.createJsydReqSeq());
        ResultData data = new ResultData();
        data.setOrderId(orderId);
        data.setDdrCity("22");
        header.setContent(data);
        String formData = JaxbUtil.convertToXml(header);
        logger.info("江苏移动受理类接口最终结果查询请求url:{},报文:{}",supplierReqData.getUrl(),formData);
        String response = JsydHttpClient.postRequest(supplierReqData.getUrl(), formData);
        logger.info("江苏移动受理类接口最终结果响应报文："+response);
        response = JsonHelper.xml2json(response);
        Map<String, Object> resultMap1 = JsonHelper.toMap(response);
        String resp_code = (String) ((Map) resultMap1.get("response")).get("resp_code");
        if ("0000".equals(resp_code)) {
            Map<String, Object> contentMap = (Map<String, Object>) resultMap1.get("content");
            return JsonHelper.toJson(contentMap);
        }
        return null;
    }
}
