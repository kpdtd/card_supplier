package com.anl.card.constant;

/**
 * 流量卡状态
 * Created by hechuanzhen on 17/12/28.
 */
public class CardState {

    //'1-测试期  2-沉默期  3-正使用  4-停机 5-销户  6-预约销户',
    public static final int CARD_TEST_FINISH = 1;
    public static final int CARD_ACTIVATE_FINISH = 2;
    public static final int CARD_USING = 3; // 正使用
    public static final int CELL_PHONE_DOWN = 4; // 停机


}
