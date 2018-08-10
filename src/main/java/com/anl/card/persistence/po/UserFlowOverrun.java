package com.anl.card.persistence.po;

import java.util.*;

public class UserFlowOverrun {
	private Integer id;
	private Integer cardId;
	private Integer flow;
	private Integer balance;
	private Date billDate;
	private Integer state;
	private Date createTime;
	private Date updateTime;
	
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setCardId(Integer value) {
		this.cardId = value;
	}
	
	public Integer getCardId() {
		return this.cardId;
	}
	public void setFlow(Integer value) {
		this.flow = value;
	}
	
	public Integer getFlow() {
		return this.flow;
	}
	public void setBalance(Integer value) {
		this.balance = value;
	}
	
	public Integer getBalance() {
		return this.balance;
	}
	public void setBillDate(Date value) {
		this.billDate = value;
	}
	
	public Date getBillDate() {
		return this.billDate;
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
	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}
}

