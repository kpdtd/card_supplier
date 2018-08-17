package com.anl.card.logic;

import com.anl.card.constant.ProcessAction;
import com.anl.card.dto.FlowDailyData;
import com.anl.card.persistence.po.*;
import com.anl.card.service.*;
import com.anl.card.util.DateUtil;
import com.anl.card.util.LogFactory;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangyiqiang on 2018/8/10.
 * 流量卡日流量使用查询,根据任务配置的时间点从上游获取流量使用情况,并更新流量日使用表
 */
@Service
public class CardFlowDayUsedLogicImpl implements CardFlowDayUsedLogic {
    @Autowired
    CardService cardService;
    @Autowired
    SupplierService supplierService;
    @Autowired
    SupplierInterfaceItemService supplierInterfaceItemService;
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    InterfaceListService interfaceListService;
    @Autowired
    UserFlowUsedDayService userFlowUsedDayService;
    @Autowired
    UserFlowUsedMonthService userFlowUsedMonthService;
    @Autowired
    RealnameAuthenticationService realnameAuthenticationService;
    Logger logger = LogFactory.getInstance().getLogger();

    @Override
    public boolean deal(Card card) throws Exception {
        boolean isEarlyMonth = DateUtil.isEarlyMonth();
        String action = ProcessAction.FLOW_DAY_SEARCH;
        InterfaceList interfaceList = new InterfaceList();
        interfaceList.setTag(action);//日流量查询的tag
        List<InterfaceList> interfaceListList = interfaceListService.getListByPo(interfaceList);
        if (CollectionUtils.isEmpty(interfaceListList)) {
            logger.error("流量卡日流量使用查询操作错误,没有定义对应的接口TAG=" + action);
            return false;
        }
        Supplier supplier = supplierService.getById(card.getSupplierId());
        if (supplier == null) {
            logger.error("流量卡日流量使用查询操作错误,没有对应的上游信息,SupplierId=" + card.getSupplierId());
            return false;
        }
        //这里返回的是列表，应该加一个参数：接口标识串，直接定位到具体的接口信息
        SupplierInterfaceItem item = supplierInterfaceItemService.getItemBySupplierIdAndInterfaceId(card.getSupplierId(), interfaceListList.get(0).getId());
        if (item == null || item.getId() == 0) {
            logger.error("流量卡日流量使用查询操作错误,该上游没有对应的接口实现,SupplierId=" + card.getSupplierId());
            return false;
        }
        logger.info("流量卡日流量使用查询,调用的上游类" + item.getClassName());
        BaseLogic logic = (BaseLogic) applicationContext.getBean(item.getClassName());
        FlowDailyData flowDailyData = null;
        //江苏移动只提供月查询接口,如果是当月第一天,则需要传上个月的月份才对.
        if (isEarlyMonth) {
            String beforeMonthLastDay = DateUtil.dateToString(DateUtil.getLastDayOfBeforeMonth(), DateUtil.DATE_FORMAT_MONTH);
            flowDailyData = (FlowDailyData) logic.deal(card, supplier, item, beforeMonthLastDay);
            logger.info("每月1号查询{}接口调用返回结果: {}", beforeMonthLastDay, (flowDailyData != null ? flowDailyData.toString() : null));

        } else {
            flowDailyData = (FlowDailyData) logic.deal(card, supplier, item);
            logger.info("查询当月流量接口调用返回结果: {}", (flowDailyData != null ? flowDailyData.toString() : null));
        }
        addDayFlow(card, flowDailyData);
        addMonthUsedFlow(card, flowDailyData, isEarlyMonth);
        return true;
    }

    //如果当天存在记录,直接修改
    private void addDayFlow(Card card, FlowDailyData flowDailyData) throws Exception {
        if(flowDailyData==null || flowDailyData.getDayUsedFlow()==0){
            logger.info("日流量表未增加iccid={}的记录,本次查询之后的使用量为{}", card.getIccid(), flowDailyData.getDayUsedFlow());
            return;
        }
        UserFlowUsedDay userFlowUsedDay = new UserFlowUsedDay();
        Date recordTime = DateUtil.string2Date(flowDailyData.getDay());
        userFlowUsedDay.setRecordTime(recordTime);
        userFlowUsedDay.setCardId(card.getId());
        List<UserFlowUsedDay> userFlowUsedDays = userFlowUsedDayService.getListByPo(userFlowUsedDay);
        if (CollectionUtils.isEmpty(userFlowUsedDays)) {
            userFlowUsedDay.setFlow(flowDailyData.getDayUsedFlow());
            userFlowUsedDay.setCreateTime(new Date());
            userFlowUsedDayService.insert(userFlowUsedDay);
            logger.info("日流量表增加了iccid={}的记录,本次查询之后的使用量为{}", card.getIccid(), flowDailyData.getDayUsedFlow());
        } else {
            userFlowUsedDay = userFlowUsedDays.get(0);
            int oldDayFlow = userFlowUsedDay.getFlow();
            userFlowUsedDay.setFlow(flowDailyData.getDayUsedFlow());
            userFlowUsedDay.setCreateTime(new Date());
            userFlowUsedDayService.update(userFlowUsedDay);
            logger.info("日流量表存在iccid={}的记录,使用量为{},本次查询之后的使用量为{}", card.getIccid(), oldDayFlow, flowDailyData.getDayUsedFlow());
        }
    }

    //如果存在当月的记录,直接返回
    private void addMonthUsedFlow(Card card, FlowDailyData flowDailyData, boolean isEarlyMonth) throws Exception {
        if(flowDailyData==null || flowDailyData.getMonthUsedFlow()==0){
            logger.info("月流量表未增加iccid={}的记录,本次查询之后的使用量为{}", card.getIccid(), flowDailyData.getDayUsedFlow());
            return;
        }
        UserFlowUsedMonth userFlowUsedMonth = new UserFlowUsedMonth();
        userFlowUsedMonth.setCardId(card.getId());
        if (isEarlyMonth) {
            userFlowUsedMonth.setBillDate(DateUtil.getFirstDayOfBeforeMonth());
        } else {
            userFlowUsedMonth.setBillDate(DateUtil.getFristDayOfMonth());
        }
        List<UserFlowUsedMonth> userFlowUsedMonths = userFlowUsedMonthService.getListByPo(userFlowUsedMonth);
        if (CollectionUtils.isEmpty(userFlowUsedMonths)) {
            userFlowUsedMonth.setCreateTime(new Date());
            userFlowUsedMonth.setActualUse(flowDailyData.getMonthUsedFlow());
            userFlowUsedMonth.setBatchNumber(DateUtil.getCurDateTime(DateUtil.DATE_FORMAT_COMPACT));
            userFlowUsedMonth.setCardState(card.getCardState());
            userFlowUsedMonth.setIccid(card.getIccid());
            userFlowUsedMonth.setSuplierId(card.getSupplierId());
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("cardId", card.getId());
            List<RealnameAuthentication> raList = realnameAuthenticationService.getListByMap(dataMap);
            if (!raList.isEmpty()) {
                userFlowUsedMonth.setPhone(raList.get(0).getPhone());
            }
            userFlowUsedMonthService.insert(userFlowUsedMonth);
            logger.info("月流量表增加iccid={}的记录,本次查询的使用量为:{}", card.getIccid(),flowDailyData.getMonthUsedFlow());
        } else {
            logger.info("月流量表存在iccid={}的记录", card.getIccid());
        }
    }

}
