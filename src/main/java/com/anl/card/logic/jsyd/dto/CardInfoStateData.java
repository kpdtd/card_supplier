package com.anl.card.logic.jsyd.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author lianzf
 * @Description:
 * @date 18/5/2下午5:08
 */
@XmlAccessorType( XmlAccessType.FIELD)
@XmlRootElement(name = "content")
public class CardInfoStateData {
    @XmlElement(name = "ddr_city")
    private String ddrCity;
    @XmlElement(name = "msisdn")
    private String msisdn;

    public String getDdrCity() {
        return ddrCity;
    }

    public void setDdrCity(String ddrCity) {
        this.ddrCity = ddrCity;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }
}
