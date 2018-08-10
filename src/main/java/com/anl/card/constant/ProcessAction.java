package com.anl.card.constant;

/**
 * 卡的处理动作定义常量类
 */
public class ProcessAction {

    /**
     * 卡开停机动作
     * 1、开机，开机包括两种1-开卡 2-终止测试期
     * 2、停机
     */
    // 卡开机
    public static final String CARD_OPEN = "openCard";
    // 卡停机
    public static final String CARD_CLOSE = "closeCard";
    // 测试期终止
    public static final String CARD_TEST_FINISH = "CARD_TEST_FINISH";
    // 沉默期终止
    public static final String CARD_FINISH_ACTIVATE = "CARD_FINISH_ACTIVATE";
    /**
     * TODO 卡开停GPRS
     * 该接口目前还没有上游支持
     */
    // gprs开
    public static final String GPRS_OPEN = "GPRS_OPEN";
    // gprs关
    public static final String GPRS_CLOSE = "GPRS_CLOSE";
    // 测试期到期处理 为测试期变更为沉默期
    public static final String  CARD_TEST_SILENT = "CARD_TEST_SILENT";
    // 沉默期激活处理，为沉默期变更为正使用
    public static final String CARD_SILENT_USING = "CARD_SILENT_USING";
}
