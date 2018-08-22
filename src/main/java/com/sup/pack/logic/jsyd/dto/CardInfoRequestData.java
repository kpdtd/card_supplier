package com.sup.pack.logic.jsyd.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author lianzf
 * @Description:
 * @date 18/4/15下午1:18
 */
@XmlAccessorType( XmlAccessType.FIELD)
@XmlRootElement(name = "content")
public class CardInfoRequestData {

    @XmlElement(name = "msisdn")
    private String msisdn;
    @XmlElement(name = "ddr_city")
    private String ddrCity;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getDdrCity() {
        return ddrCity;
    }

    public void setDdrCity(String ddrCity) {
        this.ddrCity = ddrCity;
    }
}
