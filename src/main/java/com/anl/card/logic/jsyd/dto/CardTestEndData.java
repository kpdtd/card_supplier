package com.anl.card.logic.jsyd.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author lianzf
 * @Description:
 * @date 18/5/3下午1:49
 */
@XmlAccessorType( XmlAccessType.FIELD)
@XmlRootElement(name = "content")
public class CardTestEndData {
    @XmlElement(name = "groupid")
    private String groupId = "51530885359";
    @XmlElement(name = "telnum")
    private String telnum;

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
}
