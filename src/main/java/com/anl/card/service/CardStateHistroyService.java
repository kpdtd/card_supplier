package com.anl.card.service;

import com.anl.card.persistence.po.Card;
import com.anl.card.persistence.po.CardStateHistroy;
/** 
 * 类名: CardStateHistroyService
 * 创建日期: 
 * 功能描述: 
 */
public interface CardStateHistroyService extends BaseService<CardStateHistroy> {
    void insertHistoryByIotCard(Card card, Integer originalState, String tiggerPoint) throws Exception;
}