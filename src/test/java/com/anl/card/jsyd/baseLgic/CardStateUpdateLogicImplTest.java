package com.anl.card.jsyd.baseLgic;

import com.anl.card.constant.ProcessAction;
import com.anl.card.logic.CardStateUpdateLogic;
import com.anl.card.persistence.po.Card;
import com.anl.card.service.CardService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yangyiqiang on 2018/8/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:mybatis-config.xml"})
public class CardStateUpdateLogicImplTest {

    @Autowired
    CardStateUpdateLogic cardStateUpdateLogic;
    @Autowired
    CardService cardService;
    Card card;
    @Before
    public void setUp()throws Exception{
        card=cardService.getById(88);
    }
    @Test
    public void dealTest()throws  Exception{
        cardStateUpdateLogic.deal(card, ProcessAction.CARD_OPEN,"测试开卡");
    }

}
