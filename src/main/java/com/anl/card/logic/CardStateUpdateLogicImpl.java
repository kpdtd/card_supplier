package com.anl.card.logic;

import com.anl.card.constant.CardState;
import com.anl.card.constant.Constant;
import com.anl.card.constant.ProcessAction;
import com.anl.card.persistence.po.Card;
import com.anl.card.persistence.po.InterfaceList;
import com.anl.card.persistence.po.Supplier;
import com.anl.card.persistence.po.SupplierInterfaceItem;
import com.anl.card.service.*;
import com.anl.card.util.LogFactory;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by yangyiqiang on 2018/8/10.
 * 流量卡开关卡操作
 */
@Service
public class CardStateUpdateLogicImpl implements CardStateUpdateLogic {
    @Autowired
    CardService cardService;
    @Autowired
    SupplierService supplierService;
    @Autowired
    InterfaceListService interfaceListService;
    @Autowired
    SupplierInterfaceItemService supplierInterfaceItemService;
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    CardStateHistroyService cardStateHistroyService;

    Logger logger = LogFactory.getInstance().getLogger();

    @Override
    public boolean deal(Card card, String action, String operateInfo) throws Exception {
        Integer originalState = card.getCardState();
        Supplier supplier = supplierService.getById(card.getSupplierId());
        if (supplier == null) {
            logger.error("流量卡开关卡操作错误,没有对应的上游信息,SupplierId=" + card.getSupplierId());
            return false;
        }
        InterfaceList interfaceList = new InterfaceList();
        interfaceList.setTag(action);
        List<InterfaceList> interfaceListList = interfaceListService.getListByPo(interfaceList);
        if (CollectionUtils.isEmpty(interfaceListList)) {
            logger.error("流量卡开关卡操作错误,没有定义对应的接口TAG=" + action);
            return false;
        }
        SupplierInterfaceItem item = supplierInterfaceItemService.getItemBySupplierIdAndInterfaceId(supplier.getId(), interfaceListList.get(0).getId());
        if(item==null || item.getId()==0){
            logger.error("流量卡开关卡操作错误,该上游没有对应的接口实现,SupplierId=" + card.getSupplierId());
            return false;
        }
        logger.info("流量卡开关卡,调用的上游类" + item.getClassName());
        BaseLogic logic = (BaseLogic) applicationContext.getBean(item.getClassName());
        Map<String, String> resultMap = (Map<String, String>) logic.deal(card, supplier, item, action);
        if (resultMap != null && resultMap.get("result").equals("success")) {
            if (ProcessAction.CARD_OPEN.equals(action)) {
                //开卡操作
                card.setCardState(CardState.CARD_USING);
                cardStateHistroyService.insertHistoryByIotCard(card, originalState, operateInfo);//operateInfo为状态更改操作说明,比如"购买订单开机"
            } else if (ProcessAction.CARD_CLOSE.equals(action)) {
                //停卡操作
                card.setCardState(CardState.CELL_PHONE_DOWN);
                cardStateHistroyService.insertHistoryByIotCard(card, originalState, operateInfo);
            }
            cardService.update(card);
            logger.info("卡iccid{}调用停开机成功", card.getIccid());
            //如果是江苏卡,则需要异步回调获取最终的操作结果
            if (Constant.jsyd_eccode.equals(supplier.getEcCode())) {
                //待实现
            }
        } else {
            //操作失败
            logger.error("卡iccid{}调用停开机接口失败.", card.getIccid());
        }
        return true;
    }
}
