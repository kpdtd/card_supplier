package com.anl.card.logic.jsyd;


import com.anl.card.dto.CardInfoData;
import com.anl.card.logic.BaseLogic;
import com.anl.card.logic.jsyd.dto.CardInfoRequestData;
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
 * @Description:江苏移动卡信息查询接口
 * @date 18/4/15下午2:47
 */
@Service
public class JsydCardInfoLogicImpl implements BaseLogic {

    private static final org.slf4j.Logger logger = LogFactory.getInstance().getLogger();

    @Override
    public CardInfoData deal(Card card, Supplier supplier, SupplierInterfaceItem item, Object... obj) {
        try {
            String appId = JsonHelper.toMap(supplier.getEcExtensionInfo()).get("appId").toString();
            String tokenSign = supplier.getInvokeToken();
            String interfaceTag = item.getEcCode();
            RequestHeader header = new RequestHeader();
            header.setAppId(appId);
            header.setAccessToken(tokenSign);
            header.setProcessCode(interfaceTag);
            header.setReqSeq(SeqIdGenerator.createJsydReqSeq());
            CardInfoRequestData data = new CardInfoRequestData();
            data.setMsisdn(card.getMsisdn());
            data.setDdrCity("22");// TODO 暂不知道如何获取 目前只有盐城一个地方的地区，没有获取地区的方式，只能写死
            header.setContent(data);
            String formData = JaxbUtil.convertToXml(header);
            String url = item.getUrl();
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
                    cardInfoData.setMsisdn(card.getMsisdn());
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
