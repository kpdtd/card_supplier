package com.sup.pack.logic.jsyd;

import com.sup.pack.constant.Constant;
import com.sup.pack.dto.FlowDailyData;
import com.sup.pack.dto.SupplierReqData;
import com.sup.pack.logic.BaseLogic;
import com.sup.pack.logic.jsyd.dto.CardFlowRequestData;
import com.sup.pack.logic.jsyd.dto.RequestHeader;
import com.sup.pack.logic.jsyd.util.JsydHttpClient;
import com.sup.pack.util.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lianzf
 * @Description:江苏移动流量卡流量使用查询,文档和实际接口返回数据不一致,需要和上游沟通,开发的时候按照实际返回的数据进行解析的.
 * @date 18/4/15上午9:49
 */
@Service
public class JsydCardInfoTermLogicImpl implements BaseLogic {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(JsydCardInfoTermLogicImpl.class);

    @Override
    public FlowDailyData deal(SupplierReqData supplierReqData) {
        FlowDailyData flowDailyData = new FlowDailyData();
        try {
            String appId = JsonHelper.toMap(supplierReqData.getEcExtensionInfo()).get("appId").toString();
            String tokenSign = supplierReqData.getInvokeToken();
            String interfaceTag = supplierReqData.getInterfaceInfo();
            RequestHeader header = new RequestHeader();
            header.setAppId(appId);
            header.setAccessToken(tokenSign);
            header.setProcessCode(interfaceTag);
            header.setReqSeq(SeqIdGenerator.createJsydReqSeq());
            CardFlowRequestData data = new CardFlowRequestData();
            data.setServiceNumber(supplierReqData.getMsisdn());
            String month = DateUtil.getCurDateTime(DateUtil.DATE_FORMAT_MONTH);
            if(StringUtils.isNotBlank(supplierReqData.getMonth())){
                month = supplierReqData.getMonth();
            }

            data.setCycle(month);
            header.setContent(data);
            String formData = JaxbUtil.convertToXml(header);
            String url = supplierReqData.getUrl();
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
                        flowDailyData.setCardId(supplierReqData.getCardId());
                        flowDailyData.setMonth(month);
                        //换算成M
                        monthUsedFlow = monthUsedFlow / Constant.FLOW_UNIT + (monthUsedFlow % Constant.FLOW_UNIT > 0 ? 1 : 0);
                        flowDailyData.setMonthUsedFlow(monthUsedFlow);
                    }
                    // 当前月用户在我平台的已使用总量
                    Integer usedFlow = supplierReqData.getUsedFlow();
                    usedFlow = (usedFlow == null ? 0 : usedFlow);
                    int currentDayUsedFlow = 0;
                    currentDayUsedFlow = monthUsedFlow - usedFlow;
                    logger.info("江苏移动查询到的本月使用量为{}M,本月已记录的使用量{}M, " + ",今日用量{}M", monthUsedFlow, usedFlow, currentDayUsedFlow);
                    flowDailyData.setDayUsedFlow(currentDayUsedFlow);
                    flowDailyData.setDay(DateUtil.dateToString(DateUtil.afterNDaysDate(new Date(), -1), DateUtil.DATE_FORMAT_COMPACT));
                }
            }
        } catch (Exception e) {
            logger.error("江苏移动卡实时流量查询错误: " + e);
            e.printStackTrace();
        }
        return flowDailyData;
    }

}
