package com.anl.card.logic.jsyd;

import com.anl.card.logic.BaseLogic;
import com.anl.card.logic.jsyd.dto.CardPoolRequestData;
import com.anl.card.logic.jsyd.dto.RequestHeader;
import com.anl.card.logic.jsyd.util.JsydHttpClient;
import com.anl.card.persistence.po.Card;
import com.anl.card.persistence.po.Supplier;
import com.anl.card.persistence.po.SupplierInterfaceItem;
import com.anl.card.util.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Created by yangyiqiang on 2018/8/9.
 *
 * @Description:江苏移动流量池接口
 */
@Service
public class JsydCardPoolLogicImpl implements BaseLogic {
    private static final org.slf4j.Logger logger = LogFactory.getInstance().getLogger();

    @Override
    public Object deal(Card card, Supplier supplier, SupplierInterfaceItem supplierInterfaceItem, Object... obj) throws Exception {
        String appId = JsonHelper.toMap(supplier.getEcExtensionInfo()).get("appId").toString();
        String tokenSign = supplier.getInvokeToken();
        String interfaceTag = supplierInterfaceItem.getInterfaceInfo();//接口名称
        RequestHeader header = new RequestHeader();
        header.setAppId(appId);
        header.setAccessToken(tokenSign);
        header.setProcessCode(interfaceTag);
        header.setReqSeq(SeqIdGenerator.createJsydReqSeq());
        CardPoolRequestData data = new CardPoolRequestData();
        data.setCycle(DateUtil.getCurDateTime(DateUtil.DATE_FORMAT_MONTH));
        data.setQrytype("0");
        data.setEccode(supplier.getEcCode());
        header.setContent(data);
        String formData = JaxbUtil.convertToXml(header);
        String url = supplierInterfaceItem.getUrl();
        logger.info("江苏移动流量池接口请求: {}, 参数: {}", url, formData);
        String result = JsydHttpClient.postRequest(url, formData);
        if (StringUtils.isNotBlank(result)) {
            logger.info("江苏移动流量池接口响应: {}", result);
            result = JsonHelper.xml2json(result);
            logger.info("江苏移动流量池接口转换成json : " + result);
        }
        return null;
    }
}
