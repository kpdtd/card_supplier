package com.sup.pack.logic;

import com.sup.pack.dto.SupplierReqData;

/**
 * Created by yangyiqiang on 2018/8/10.
 * 流量卡状态变更,开卡或者是停卡
 */
public interface CardStateUpdateLogic {

    public boolean deal(SupplierReqData supplierReqData) throws Exception;

}
