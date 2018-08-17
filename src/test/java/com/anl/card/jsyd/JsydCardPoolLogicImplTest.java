package com.anl.card.jsyd;

import com.anl.card.logic.jsyd.JsydCardPoolLogicImpl;
import com.anl.card.persistence.po.Card;
import com.anl.card.persistence.po.Supplier;
import com.anl.card.persistence.po.SupplierInterfaceItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yangyiqiang on 2018/8/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml", "classpath:mybatis-config.xml"})
public class JsydCardPoolLogicImplTest {

    @Autowired
    JsydCardPoolLogicImpl jsydCardPoolLogic;
    SupplierInterfaceItem supplierInterfaceItem;
    Supplier supplier;
    Card card;

    @Before
    public void setUp(){
        supplier=new Supplier();
        supplier.setInvokeToken("vjU47Schsh1fL2D7oSql");
        supplier.setEcCode("250321176250250000");
        supplierInterfaceItem=new  SupplierInterfaceItem();
        supplierInterfaceItem.setInterfaceInfo("OPEN_QRYINTERNETGRPPOOLGPRS");//接口名称
        supplierInterfaceItem.setUrl("http://221.178.251.182:80/internet_surfing");
        supplier.setEcExtensionInfo("{\"groupId\": \"51530885359\",\"appId\": \"109000000224\"}");
    }
    @Test
    public void dealTest() throws Exception {
        jsydCardPoolLogic.deal(card,supplier,supplierInterfaceItem);
    }
}
