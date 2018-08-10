package com.anl.card.logic;


import com.anl.card.persistence.po.Card;
import com.anl.card.persistence.po.Supplier;
import com.anl.card.persistence.po.SupplierInterfaceItem;

public interface BaseLogic {
	Object deal(Card card, Supplier supplier, SupplierInterfaceItem supplierInterfaceItem, Object... obj) throws Exception;
}