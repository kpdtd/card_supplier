package com.anl.card.logic;

import com.anl.card.persistence.po.Card;
import org.springframework.stereotype.Service;

/**
 * Created by yangyiqiang on 2018/8/10.
 * 流量卡日流量使用查询,根据任务配置的时间点从上游获取流量使用情况,并更新流量日使用表
 */
@Service
public class CardFlowDayUsedLogicImpl implements CardFlowDayUsedLogic {
    @Override
    public boolean deal(Card card) throws Exception {
        return false;
    }
}
