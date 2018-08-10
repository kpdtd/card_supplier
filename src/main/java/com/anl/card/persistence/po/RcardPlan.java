package com.anl.card.persistence.po;

import java.util.*;

public class RcardPlan {
	private Integer id;
	private Integer cardId;
	private Integer planId;
	private Date startTime;
	private Date endTime;
	private Date createTime;
	
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
	public void setPlanId(Integer value) {
		this.planId = value;
	}
	
	public Integer getPlanId() {
		return this.planId;
	}
	public void setStartTime(Date value) {
		this.startTime = value;
	}
	
	public Date getStartTime() {
		return this.startTime;
	}
	public void setEndTime(Date value) {
		this.endTime = value;
	}
	
	public Date getEndTime() {
		return this.endTime;
	}
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
}

