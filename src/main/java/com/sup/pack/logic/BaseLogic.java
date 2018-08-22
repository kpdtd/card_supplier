package com.sup.pack.logic;


import com.sup.pack.dto.SupplierReqData;

public interface BaseLogic {
	Object deal(SupplierReqData supplierReqData) throws Exception;
}