package com.anl.card.logic.jsyd;

import com.anl.card.logic.BaseLogic;
import com.anl.card.logic.jsyd.dto.CardCycleData;
import com.anl.card.logic.jsyd.dto.RequestHeader;
import com.anl.card.logic.jsyd.util.JsydHttpClient;
import com.anl.card.persistence.po.Card;
import com.anl.card.persistence.po.Supplier;
import com.anl.card.persistence.po.SupplierInterfaceItem;
import com.anl.card.util.JaxbUtil;
import com.anl.card.util.JsonHelper;
import com.anl.card.util.LogFactory;
import com.anl.card.util.SeqIdGenerator;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author lianzf
 * @Description:生命周期查询接口
 * @date 18/5/8上午9:55
 */
@Service
public class JsydCardCycleLogicImpl implements BaseLogic {

    private static final org.slf4j.Logger logger = LogFactory.getInstance().getLogger();
    @Override
    public Object deal(Card card, Supplier supplier, SupplierInterfaceItem item, Object... obj) throws Exception {
        String appId = JsonHelper.toMap(supplier.getEcExtensionInfo()).get("appId").toString();
        String tokenSign = supplier.getInvokeToken();
        String interfaceTag = item.getInterfaceInfo();
        RequestHeader header = new RequestHeader();
        header.setAppId(appId);
        header.setAccessToken(tokenSign);
        header.setReqType(1);
        header.setProcessCode(interfaceTag);
        header.setReqSeq(SeqIdGenerator.createJsydReqSeq());
        CardCycleData data = new CardCycleData();
        data.setTelnum(card.getMsisdn());
        header.setContent(data);
        String formData = JaxbUtil.convertToXml(header);
        logger.info("江苏移动卡生命周期请求URL: {}, 报文: {}",item.getUrl(),formData);
        String response = JsydHttpClient.postRequest(item.getUrl(), formData);
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
                        card.setCardState(1);
                    }else if("2".equals(cycle)){
                        card.setCardState(2);
                    }else if("3".equals(cycle)){
                        card.setCardState(3);
                    }else{
                        card.setCardState(99); // TODO 未知状态，不与操作
                    }
                    return card;
                }
            }
        }
        return null;
    }
}
