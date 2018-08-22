package com.sup.pack.logic.jsyd;

import com.sup.pack.dto.SupplierReqData;
import com.sup.pack.logic.BaseLogic;
import com.sup.pack.logic.jsyd.dto.CardPoolRequestData;
import com.sup.pack.logic.jsyd.dto.RequestHeader;
import com.sup.pack.logic.jsyd.util.JsydHttpClient;
import com.sup.pack.util.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by yangyiqiang on 2018/8/9.
 *
 * @Description:江苏移动流量池接口
 */
@Service
public class JsydCardPoolLogicImpl implements BaseLogic {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(JsydCardPoolLogicImpl.class);

    @Override
    public Object deal(SupplierReqData supplierReqData) throws Exception {
        String appId = JsonHelper.toMap(supplierReqData.getEcExtensionInfo()).get("appId").toString();
        String tokenSign = supplierReqData.getInvokeToken();
        String interfaceTag = supplierReqData.getInterfaceInfo();//接口名称
        RequestHeader header = new RequestHeader();
        header.setAppId(appId);
        header.setAccessToken(tokenSign);
        header.setProcessCode(interfaceTag);
        header.setReqSeq(SeqIdGenerator.createJsydReqSeq());
        CardPoolRequestData data = new CardPoolRequestData();
        data.setCycle(DateUtil.getCurDateTime(DateUtil.DATE_FORMAT_MONTH));
        data.setQrytype("0");
        data.setEccode(supplierReqData.getEcCode());
        header.setContent(data);
        String formData = JaxbUtil.convertToXml(header);
        String url = supplierReqData.getUrl();
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
