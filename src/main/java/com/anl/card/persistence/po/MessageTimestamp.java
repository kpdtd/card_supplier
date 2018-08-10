package com.anl.card.persistence.po;

import java.util.*;

public class MessageTimestamp {
	private Integer agencyId;
	private Date updateTime;
	
	public void setAgencyId(Integer value) {
		this.agencyId = value;
	}
	
	public Integer getAgencyId() {
		return this.agencyId;
	}
	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}
}

