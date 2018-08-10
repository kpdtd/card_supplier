package com.anl.card.logic.jsyd;

import com.anl.card.dto.FlowDailyData;
import com.anl.card.logic.BaseLogic;
import com.anl.card.logic.jsyd.dto.CardFlowRequestData;
import com.anl.card.logic.jsyd.dto.RequestHeader;
import com.anl.card.logic.jsyd.util.JsydHttpClient;
import com.anl.card.persistence.po.Card;
import com.anl.card.persistence.po.Supplier;
import com.anl.card.persistence.po.SupplierInterfaceItem;
import com.anl.card.service.ResultOverrunRecordService;
import com.anl.card.service.UserFlowUsedDayService;
import com.anl.card.util.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lianzf
 * @Description:江苏移动流量卡流量使用查询,文档和实际接口返回数据不一致,需要和上游沟通,开发的时候按照实际返回的数据进行解析的.
 * @date 18/4/15上午9:49
 */
@Service
public class JsydCardInfoTermLogicImpl implements BaseLogic {

    private static final org.slf4j.Logger logger = LogFactory.getInstance().getLogger();
    @Autowired
    UserFlowUsedDayService userFlowUsedDayService;
    @Autowired
    ResultOverrunRecordService resultOverrunRecordService;
    @Autowired
    RedisFactory redisFactory;

    @Override
    public FlowDailyData deal(Card card, Supplier supplier, SupplierInterfaceItem item, Object... obj) {
        FlowDailyData flowDailyData = new FlowDailyData();
        try {
            String appId = JsonHelper.toMap(supplier.getEcExtensionInfo()).get("appId").toString();
            String tokenSign = supplier.getInvokeToken();
            String interfaceTag = item.getEcCode();
            RequestHeader header = new RequestHeader();
            header.setAppId(appId);
            header.setAccessToken(tokenSign);
            header.setProcessCode(interfaceTag);
            header.setReqSeq(SeqIdGenerator.createJsydReqSeq());
            CardFlowRequestData data = new CardFlowRequestData();
            data.setServiceNumber(card.getMsisdn());
            String month = DateUtil.getCurDateTime(DateUtil.DATE_FORMAT_MONTH);
            data.setCycle(month);
            header.setContent(data);
            String formData = JaxbUtil.convertToXml(header);
            String url = item.getUrl();
            logger.info("江苏移动卡实时流量查询请求: {}, 参数: {}", url, formData);
            String result = JsydHttpClient.postRequest(url, formData);
            if (StringUtils.isNotBlank(result)) {
                logger.info("江苏移动卡实时流量查询响应: {}", result);
                result = JsonHelper.xml2json(result);
                logger.info("江苏移动卡实时流量查询转换成json : " + result);
                Map<String, Object> resultMap = JsonHelper.toMap(result);
                String resp_code = (String) ((Map) resultMap.get("response")).get("resp_code");
                if ("0000".equals(resp_code)) {
                    Map<String, Object> contentMap = (Map<String, Object>) resultMap.get("content");
                    Map<String, Object> cardFlowMap = new HashMap<String, Object>();
                    if (contentMap.get("poollist") != null) {
                        cardFlowMap = (Map<String, Object>) ((Map<String, Object>) contentMap.get("poollist")).get("poolinfo");
                    } else if (contentMap.get("prodlist") != null) {
                        cardFlowMap = (Map<String, Object>) contentMap.get("prodlist");
                    } else {
                        logger.error("江苏移动卡实时流量查询数据返回格式错误,无法解析 result=: " + result);
                    }
                    Integer monthUsedFlow = 0;
                    if (cardFlowMap.get("cumulate_value") != null && Integer.parseInt(cardFlowMap.get("cumulate_value").toString()) >= 0) {
                        monthUsedFlow = Integer.parseInt(cardFlowMap.get("cumulate_value").toString());
                        flowDailyData.setCardId(card.getId());
                        flowDailyData.setMonth(month);
                        flowDailyData.setMonthUsedFlow(monthUsedFlow);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("江苏移动卡实时流量查询错误: " + e);
            e.printStackTrace();
        }
        return flowDailyData;
    }

}
