package com.anl.card.service;

import com.anl.card.persistence.po.SupplierInterfaceItem;
/** 
 * 类名: SupplierInterfaceItemService
 * 创建日期: 
 * 功能描述: 
 */
public interface SupplierInterfaceItemService extends BaseService<SupplierInterfaceItem> {

    SupplierInterfaceItem getItemBySupplierIdAndInterfaceId(Integer supplierId, Integer interfaceId) throws Exception;
}