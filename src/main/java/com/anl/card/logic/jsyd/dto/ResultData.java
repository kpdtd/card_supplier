package com.anl.card.logic.jsyd.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author lianzf
 * @Description:
 * @date 18/4/26下午6:19
 */
@XmlAccessorType( XmlAccessType.FIELD)
@XmlRootElement(name = "content")
public class ResultData {
    @XmlElement(name = "ddr_city")
    private String ddrCity;
    @XmlElement(name = "orderid")
    private String orderId;

    public String getDdrCity() {
        return ddrCity;
    }

    public void setDdrCity(String ddrCity) {
        this.ddrCity = ddrCity;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
