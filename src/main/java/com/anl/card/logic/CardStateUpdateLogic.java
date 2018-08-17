package com.anl.card.logic;

import com.anl.card.persistence.po.Card;

/**
 * Created by yangyiqiang on 2018/8/10.
 * 流量卡状态变更,开卡或者是停卡
 */
public interface CardStateUpdateLogic {

    public boolean deal(Card card,String action,String operateInfo) throws Exception;

}
