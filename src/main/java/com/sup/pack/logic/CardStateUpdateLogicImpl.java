package com.sup.pack.logic;

import com.sup.pack.constant.Constant;
import com.sup.pack.dto.SupplierReqData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by yangyiqiang on 2018/8/10.
 * 流量卡开关卡操作
 */
@Service
public class CardStateUpdateLogicImpl implements CardStateUpdateLogic {

    @Autowired
    ApplicationContext applicationContext;

    Logger logger = LoggerFactory.getLogger(CardStateUpdateLogicImpl.class);

    @Override
    public boolean deal(SupplierReqData supplierReqData) throws Exception {
        Integer originalState = supplierReqData.getCardState();
        logger.info("流量卡开关卡,调用的上游类" + supplierReqData.getClassName());
        BaseLogic logic = (BaseLogic) applicationContext.getBean(supplierReqData.getClassName());
        Map<String, String> resultMap = (Map<String, String>) logic.deal(supplierReqData);
        if (resultMap != null && resultMap.get("result").equals("success")) {
            logger.info("卡iccid{}调用停开机成功", supplierReqData.getIccid());
            //如果是江苏卡,则需要异步回调获取最终的操作结果
            if (Constant.jsyd_eccode.equals(supplierReqData.getEcCode())) {
                //待实现
            }
            return true;
        } else {
            //操作失败
            logger.error("卡iccid{}调用停开机接口失败.", supplierReqData.getIccid());

        }
        return false;
    }
}
