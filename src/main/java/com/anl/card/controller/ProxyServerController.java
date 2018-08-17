//package com.anl.card.controller;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.anl.card.logic.BaseLogic;
//import com.anl.card.persistence.po.Supplier;
//import com.anl.card.persistence.po.SupplierInterfaceItem;
//import com.anl.card.service.CardService;
//import com.anl.card.service.ErrorRetryRecordService;
//import com.anl.card.service.SupplierInterfaceItemService;
//import com.anl.card.service.SupplierService;
//import com.anl.card.util.JsonHelper;
//
///**
// */
//@Controller
//@RequestMapping( value = "/proxy" )
//public class ProxyServerController {
//    @Autowired
//    CardService cardService;
//    @Autowired
//    SupplierService supplierService;
////    @Autowired
////    SupplierInterfaceItemService supplierInterfaceItemService;
////    @Autowired
////    ApplicationContext applicationContext;
////    @Autowired
////    ErrorRetryRecordService errorRetryRecordService;
//
//    /**
//     * 停复机
//     *
//     * @param cardId
//     * @param action
//     * @return
//     */
//    @RequestMapping( value = "/switch/{cardId}/{action}", produces = "application/json; charset=utf-8")
//    public @ResponseBody String cardSwitch(@PathVariable( "cardId" ) int cardId, @PathVariable( "action" ) String action) {
//        Map<String, String> resultMap = new HashMap<>();
//        resultMap.put("result", "fail");
//        try {
//            IotCard iotCard = iotCardService.getById(cardId);
//            if (iotCard == null) {
//                resultMap.put("message", "未找到卡信息");
//                return JsonHelper.toJson(resultMap);
//            }
//            Supplier supplier = supplierService.getById(iotCard.getSupplierId());
//            if (supplier == null) {
//                resultMap.put("message", "未找到卡所属上游");
//                return JsonHelper.toJson(resultMap);
//            }
//            SupplierInterfaceItem item = supplierInterfaceItemService.getItemBySupplierIdAndTag(supplier.getId(), SupplierInterface.CARD_SWITCH);
//            if (item == null) {
//                resultMap.put("message", "该卡不支持停复机接口");
//                return JsonHelper.toJson(resultMap);
//            }
//            BaseLogic baseLogic = (BaseLogic) applicationContext.getBean(item.getClassName());
//            resultMap = (Map<String, String>) baseLogic.deal(iotCard, supplier, item, action);
//            if (!resultMap.get("result").equals("success")) {
//                errorRetryRecordService.addErrorRetryRecord(action, iotCard, 6, 2, resultMap.get("message"));
//            }
//            return JsonHelper.toJson(resultMap);
//        } catch (Exception e) {
//            e.printStackTrace();
//            resultMap.put("message", e.getMessage());
//            return JsonHelper.toJson(resultMap);
//        }
//    }
//
//    @RequestMapping( value = "/cardstate/{cardId}", produces = "application/json; charset=utf-8")
//    public @ResponseBody String cardstate(@PathVariable( "cardId" ) int cardId) {
//        Map<String, Object> resultMap = new HashMap<>();
//        resultMap.put("result", "fail");
//        try {
//            IotCard iotCard = iotCardService.getById(cardId);
//            if (iotCard == null) {
//                resultMap.put("message", "未找到卡信息");
//                return JsonHelper.toJson(resultMap);
//            }
//            Supplier supplier = supplierService.getById(iotCard.getSupplierId());
//            if (supplier == null) {
//                resultMap.put("message", "未找到卡所属上游");
//                return JsonHelper.toJson(resultMap);
//            }
//            SupplierInterfaceItem item = supplierInterfaceItemService.getItemBySupplierIdAndTag(supplier.getId(), SupplierInterface.CARD_STATE_SEARCH);
//            if (item == null) {
//                resultMap.put("message", "该卡不支持卡状态查询接口");
//                return JsonHelper.toJson(resultMap);
//            }
//            BaseLogic baseLogic = (BaseLogic) applicationContext.getBean(item.getClassName());
//            CardInfoTermData cardInfoTermData = (CardInfoTermData) baseLogic.deal(iotCard, supplier, item);
//            if (cardInfoTermData != null) {
//                resultMap.put("result", "success");
//                resultMap.put("state", cardInfoTermData.getCardstatus());
//                switch (cardInfoTermData.getCardstatus()) {
//                    case 3:
//                        resultMap.put("message", "正使用");
//                        break;
//                    case 4:
//                        resultMap.put("message", "停机");
//                        break;
//                    case 6:
//                        resultMap.put("message", "预约销户");
//                        break;
//                    case 5:
//                        resultMap.put("message", "销户");
//                        break;
//                    case 99:
//                        resultMap.put("message", "未知");
//                        break;
//                    case 2:
//                        resultMap.put("message", "沉默期");
//                        break;
//                    default:
//                        resultMap.put("message", "未知");
//                        break;
//                }
//            }else{
//                resultMap.put("message", "上游未查到号码相关信息");
//            }
//        } catch (Exception e) {
//            resultMap.put("message", e.getMessage());
//        }
//        return JsonHelper.toJson(resultMap);
//    }
//}
