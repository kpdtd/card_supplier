package com.anl.card.constant;

/**
 * 卡的处理动作定义常量类,对应t_interface_list的tag.
 */
public class ProcessAction {

    /**
     * 卡开停机动作
     * 1、开机
     * 2、停机
     */
    // 卡开机
    public static final String CARD_OPEN = "openCard";
    // 卡停机
    public static final String CARD_CLOSE = "closeCard";
    // 测试期终止
    public static final String CARD_TEST_FINISH = "cardTestFinish";
    // 沉默期终止
    public static final String CARD_FINISH_ACTIVATE = "cardActivateFinish";
    // gprs开
    public static final String GPRS_OPEN = "gprsOpen";
    // gprs关
    public static final String GPRS_CLOSE = "gprsClose";
    // 日流量查询
    public static final String FLOW_DAY_SEARCH = "flowDaySearch"; // 卡流量日查询
    // 月流量查询
    public static final String FLOW_MONTH_SEARCH = "flowMonthSearch";//月流量查询

}
