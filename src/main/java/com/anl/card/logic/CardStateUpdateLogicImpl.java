package com.anl.card.logic;

import com.anl.card.persistence.po.Card;
import org.springframework.stereotype.Service;

/**
 * Created by yangyiqiang on 2018/8/10.
 * 流量卡开关卡操作
 */
@Service
public class CardStateUpdateLogicImpl implements CardStateUpdateLogic {
    @Override
    public boolean deal(Card card,String action) throws Exception {

        return false;
    }
}
