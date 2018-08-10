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
public class CardPoolRequestData {

    @XmlElement(name = "qrytype")
    private String qrytype;

    @XmlElement(name = "eccode")
    private String eccode="0";

    /**
     * 查询月份
     * yyyymmdd
     */
    @XmlElement(name = "cycle")
    private String cycle;

    public String getQrytype() {
        return qrytype;
    }

    public void setQrytype(String qrytype) {
        this.qrytype = qrytype;
    }

    public String getEccode() {
        return eccode;
    }

    public void setEccode(String eccode) {
        this.eccode = eccode;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }
}
