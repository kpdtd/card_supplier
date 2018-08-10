package com.anl.card.persistence.po;

import java.util.*;

public class OrderOperationRecord {
	private Integer id;
	private Integer orderId;
	private Integer agencyId;
	private Integer state;
	private Date createTime;
	
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setOrderId(Integer value) {
		this.orderId = value;
	}
	
	public Integer getOrderId() {
		return this.orderId;
	}
	public void setAgencyId(Integer value) {
		this.agencyId = value;
	}
	
	public Integer getAgencyId() {
		return this.agencyId;
	}
	public void setState(Integer value) {
		this.state = value;
	}
	
	public Integer getState() {
		return this.state;
	}
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
}

