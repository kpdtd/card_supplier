package com.anl.card.logic.jsyd.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author lianzf
 * @Description:
 * @date 18/4/15上午10:32
 */
@XmlAccessorType( XmlAccessType.FIELD)
@XmlRootElement(name = "content")
public class CardFlowRequestData {

    @XmlElement(name = "service_number")
    private String serviceNumber;
    /**
     * 查询月份
     * yyyymmdd
     */
    @XmlElement(name = "cycle")
    private String cycle;

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }
}
