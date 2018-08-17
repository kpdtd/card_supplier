package com.anl.card.logic.jsyd;

import com.anl.card.logic.BaseLogic;
import com.anl.card.logic.jsyd.dto.CardTestEndData;
import com.anl.card.logic.jsyd.dto.RequestHeader;
import com.anl.card.logic.jsyd.util.JsydHttpClient;
import com.anl.card.persistence.po.Card;
import com.anl.card.persistence.po.Supplier;
import com.anl.card.persistence.po.SupplierInterfaceItem;
import com.anl.card.service.SupplierInterfaceItemService;
import com.anl.card.util.JaxbUtil;
import com.anl.card.util.JsonHelper;
import com.anl.card.util.LogFactory;
import com.anl.card.util.SeqIdGenerator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author lianzf
 * @Description:江苏移动卡沉默期强制激活
 * @date 18/5/3上午10:01
 */
@Service
public class JsydCardFinishActiveLogicImpl implements BaseLogic {
    private static final org.slf4j.Logger logger = LogFactory.getInstance().getLogger();
    @Autowired
    SupplierInterfaceItemService supplierInterfaceItemService;
    @Override
    public Object deal(Card iotCard, Supplier supplier, SupplierInterfaceItem item, Object... obj) throws Exception {
        try {
            String groupId = JsonHelper.toMap(supplier.getEcExtensionInfo()).get("groupId").toString();
            String appId = JsonHelper.toMap(supplier.getEcExtensionInfo()).get("appId").toString();
            String tokenSign = supplier.getInvokeToken();
            String interfaceTag = item.getInterfaceInfo();
            RequestHeader header = new RequestHeader();
            header.setAppId(appId);
            header.setAccessToken(tokenSign);
            header.setReqType(2);
            header.setProcessCode(interfaceTag);
            header.setReqSeq(SeqIdGenerator.createJsydReqSeq());
            CardTestEndData data = new CardTestEndData();
            data.setGroupId(groupId);
            data.setTelnum(iotCard.getMsisdn());
            header.setContent(data);
            String formData = JaxbUtil.convertToXml(header);
            String url = item.getUrl();
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
