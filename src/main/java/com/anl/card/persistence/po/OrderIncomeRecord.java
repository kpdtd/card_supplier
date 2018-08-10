package com.anl.card.persistence.po;

import java.util.*;

public class OrderIncomeRecord {
	private Integer id;
	private Date createTime;
	private Integer orderId;
	private String outTradeNo;
	private Date outTradeNoTime;
	private Integer agencyId;
	private String agencyName;
	private Integer cardId;
	private String batchNumber;
	private String iccid;
	private Integer planId;
	private String planName;
	private Integer money;
	private Integer income;
	private Boolean status;
	
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setOrderId(Integer value) {
		this.orderId = value;
	}
	
	public Integer getOrderId() {
		return this.orderId;
	}
	public void setOutTradeNo(String value) {
		this.outTradeNo = value;
	}
	
	public String getOutTradeNo() {
		return this.outTradeNo;
	}
	public void setOutTradeNoTime(Date value) {
		this.outTradeNoTime = value;
	}
	
	public Date getOutTradeNoTime() {
		return this.outTradeNoTime;
	}
	public void setAgencyId(Integer value) {
		this.agencyId = value;
	}
	
	public Integer getAgencyId() {
		return this.agencyId;
	}
	public void setAgencyName(String value) {
		this.agencyName = value;
	}
	
	public String getAgencyName() {
		return this.agencyName;
	}
	public void setCardId(Integer value) {
		this.cardId = value;
	}
	
	public Integer getCardId() {
		return this.cardId;
	}
	public void setBatchNumber(String value) {
		this.batchNumber = value;
	}
	
	public String getBatchNumber() {
		return this.batchNumber;
	}
	public void setIccid(String value) {
		this.iccid = value;
	}
	
	public String getIccid() {
		return this.iccid;
	}
	public void setPlanId(Integer value) {
		this.planId = value;
	}
	
	public Integer getPlanId() {
		return this.planId;
	}
	public void setPlanName(String value) {
		this.planName = value;
	}
	
	public String getPlanName() {
		return this.planName;
	}
	public void setMoney(Integer value) {
		this.money = value;
	}
	
	public Integer getMoney() {
		return this.money;
	}
	public void setIncome(Integer value) {
		this.income = value;
	}
	
	public Integer getIncome() {
		return this.income;
	}
	public void setStatus(Boolean value) {
		this.status = value;
	}
	
	public Boolean getStatus() {
		return this.status;
	}
}

