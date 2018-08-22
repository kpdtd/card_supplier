package com.sup.pack.jsyd.baseLgic;

import com.sup.pack.dto.SupplierReqData;
import com.sup.pack.logic.CardFlowDayUsedLogicImpl;
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
@ContextConfiguration(locations = {"classpath:/applicationContext.xml", "classpath:mybatis-config.xml"})
public class CardFlowDayUsedLogicImplTest {
    @Autowired
    CardFlowDayUsedLogicImpl cardFlowDayUsedLogic;

    SupplierReqData supplierReqData;
    @Before
    public void setUp()throws Exception{
        //card=cardService.getById(88);
    }
    @Test
    public void dealTest()throws  Exception{
        cardFlowDayUsedLogic.deal(supplierReqData);
    }
}

