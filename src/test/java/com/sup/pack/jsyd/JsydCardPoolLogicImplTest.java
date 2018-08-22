package com.sup.pack.jsyd;

import com.sup.pack.dto.SupplierReqData;
import com.sup.pack.logic.jsyd.JsydCardPoolLogicImpl;
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
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:mybatis-config.xml"})
public class JsydCardPoolLogicImplTest {

    @Autowired
    JsydCardPoolLogicImpl jsydCardPoolLogic;

    SupplierReqData supplierReqData;


    @Before
    public void setUp(){
        supplierReqData=new SupplierReqData();
        supplierReqData.setInvokeToken("vjU47Schsh1fL2D7oSql");
        supplierReqData.setEcCode("250321176250250000");
        supplierReqData.setInterfaceInfo("OPEN_QRYINTERNETGRPPOOLGPRS");//接口名称
        supplierReqData.setUrl("http://221.178.251.182:80/internet_surfing");
        supplierReqData.setEcExtensionInfo("{\"groupId\": \"51530885359\",\"appId\": \"109000000224\"}");
    }
    @Test
    public void dealTest() throws Exception {
        jsydCardPoolLogic.deal(supplierReqData);
    }
}
