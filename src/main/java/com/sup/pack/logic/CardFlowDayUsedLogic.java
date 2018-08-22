package com.sup.pack.logic;

import com.sup.pack.dto.FlowDailyData;
import com.sup.pack.dto.SupplierReqData;

/**
 * Created by yangyiqiang on 2018/8/10.
 */
public interface CardFlowDayUsedLogic {

    public FlowDailyData deal(SupplierReqData supplierReqData) throws Exception;

}
