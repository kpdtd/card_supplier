package com.anl.card.persistence.po;

import java.util.*;

public class CardPoolChangeHistory {
	private Integer id;
	private Integer cardId;
	private Integer originalPoolId;
	private Integer finalPoolId;
	private String triggerPoint;
	private String batchCode;
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
	public void setOriginalPoolId(Integer value) {
		this.originalPoolId = value;
	}
	
	public Integer getOriginalPoolId() {
		return this.originalPoolId;
	}
	public void setFinalPoolId(Integer value) {
		this.finalPoolId = value;
	}
	
	public Integer getFinalPoolId() {
		return this.finalPoolId;
	}
	public void setTriggerPoint(String value) {
		this.triggerPoint = value;
	}
	
	public String getTriggerPoint() {
		return this.triggerPoint;
	}
	public void setBatchCode(String value) {
		this.batchCode = value;
	}
	
	public String getBatchCode() {
		return this.batchCode;
	}
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
}

