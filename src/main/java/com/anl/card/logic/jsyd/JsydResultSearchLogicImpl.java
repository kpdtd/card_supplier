package com.anl.card.logic.jsyd;

import com.anl.card.logic.BaseLogic;
import com.anl.card.logic.jsyd.dto.RequestHeader;
import com.anl.card.logic.jsyd.dto.ResultData;
import com.anl.card.logic.jsyd.util.JsydHttpClient;
import com.anl.card.persistence.po.Card;
import com.anl.card.persistence.po.Supplier;
import com.anl.card.persistence.po.SupplierInterfaceItem;
import com.anl.card.util.JaxbUtil;
import com.anl.card.util.JsonHelper;
import com.anl.card.util.LogFactory;
import com.anl.card.util.SeqIdGenerator;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author lianzf
 * @Description:江苏移动受理类的接口最终的受理结果查询
 * @date 18/5/8上午11:23
 */
@Service
public class JsydResultSearchLogicImpl implements BaseLogic {

    private static final org.slf4j.Logger logger = LogFactory.getInstance().getLogger();
    @Override
    public Object deal(Card card, Supplier supplier, SupplierInterfaceItem item, Object... obj) throws Exception {
        String orderId = (String) obj[0];
        String appId = JsonHelper.toMap(supplier.getEcExtensionInfo()).get("appId").toString();
        String tokenSign = supplier.getInvokeToken();
        String interfaceTag = item.getInterfaceInfo();
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
        logger.info("江苏移动受理类接口最终结果查询请求url:{},报文:{}",item.getUrl(),formData);
        String response = JsydHttpClient.postRequest(item.getUrl(), formData);
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
