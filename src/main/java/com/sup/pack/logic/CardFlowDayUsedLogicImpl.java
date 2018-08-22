package com.sup.pack.logic;

import com.sup.pack.constant.ProcessAction;
import com.sup.pack.dto.FlowDailyData;
import com.sup.pack.dto.SupplierReqData;
import com.sup.pack.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by yangyiqiang on 2018/8/10.
 * 流量卡日流量使用查询,根据任务配置的时间点从上游获取流量使用情况,并更新流量日使用表
 */
@Service
public class CardFlowDayUsedLogicImpl implements CardFlowDayUsedLogic {

    @Autowired
    ApplicationContext applicationContext;
    Logger logger = LoggerFactory.getLogger(CardFlowDayUsedLogicImpl.class);

    @Override
    public FlowDailyData deal(SupplierReqData supplierReqData) throws Exception {
        boolean isEarlyMonth = DateUtil.isEarlyMonth();
        String action = ProcessAction.FLOW_DAY_SEARCH;
        logger.info("流量卡日流量使用查询,调用的上游类" + supplierReqData.getClassName());
        BaseLogic logic = (BaseLogic) applicationContext.getBean(supplierReqData.getClassName());
        FlowDailyData flowDailyData = null;
        //江苏移动只提供月查询接口,如果是当月第一天,则需要传上个月的月份才对.
        if (isEarlyMonth) {
            String beforeMonthLastDay = DateUtil.dateToString(DateUtil.getLastDayOfBeforeMonth(), DateUtil.DATE_FORMAT_MONTH);
            supplierReqData.setMonth(beforeMonthLastDay);
            flowDailyData = (FlowDailyData) logic.deal(supplierReqData);
            logger.info("每月1号查询{}接口调用返回结果: {}", beforeMonthLastDay, (flowDailyData != null ? flowDailyData.toString() : null));

        } else {
            flowDailyData = (FlowDailyData) logic.deal(supplierReqData);
            logger.info("查询当月流量接口调用返回结果: {}", (flowDailyData != null ? flowDailyData.toString() : null));
        }
        return flowDailyData;
    }

}
