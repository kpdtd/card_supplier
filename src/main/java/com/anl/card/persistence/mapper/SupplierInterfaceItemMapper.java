package com.anl.card.persistence.mapper;

import com.anl.card.persistence.mapper.BaseMapper;
import com.anl.card.persistence.po.SupplierInterfaceItem;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.PersistenceException;

/**
 * 类名: SupplierInterfaceItem
 * 创建日期: 
 * 功能描述: 
 */
public interface SupplierInterfaceItemMapper extends BaseMapper<SupplierInterfaceItem> {

    SupplierInterfaceItem getItemBySupplierIdAndInterfaceId(@Param("supplierId") Integer supplierId, @Param("interfaceId") Integer interfaceId) throws PersistenceException;
}