package com.sup.pack.logic.jsyd.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author lianzf
 * @Description:
 * @date 18/4/26下午3:21
 */
@XmlAccessorType( XmlAccessType.FIELD)
@XmlRootElement(name = "content")
public class CardSwitchData {

    @XmlElement(name = "groupid")
    private String groupId = "51530885359";
    @XmlElement(name = "telnum")
    private String telnum;
    @XmlElement(name = "oprtype")
    private String oprtype;
    @XmlElement(name = "reason")
    private String reason;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getTelnum() {
        return telnum;
    }

    public void setTelnum(String telnum) {
        this.telnum = telnum;
    }

    public String getOprtype() {
        return oprtype;
    }

    public void setOprtype(String oprtype) {
        this.oprtype = oprtype;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
