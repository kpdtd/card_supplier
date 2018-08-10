package com.anl.card.logic;

import com.anl.card.persistence.po.Card;

/**
 * Created by yangyiqiang on 2018/8/10.
 */
public interface CardFlowDayUsedLogic {

    public boolean deal(Card card) throws Exception;

}
