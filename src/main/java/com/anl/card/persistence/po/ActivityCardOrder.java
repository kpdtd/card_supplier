package com.anl.card.persistence.po;

import java.util.*;

public class ActivityCardOrder {
	private Integer id;
	private String mobile;
	private String iccid;
	private Integer money;
	private Integer payType;
	private String tradeNo;
	private Integer validDays;
	private String openId;
	private String outTradeNo;
	private String ip;
	private String payer;
	private Integer state;
	private String causes;
	private String aid;
	private Date createTime;
	private Date updateTime;
	
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setMobile(String value) {
		this.mobile = value;
	}
	
	public String getMobile() {
		return this.mobile;
	}
	public void setIccid(String value) {
		this.iccid = value;
	}
	
	public String getIccid() {
		return this.iccid;
	}
	public void setMoney(Integer value) {
		this.money = value;
	}
	
	public Integer getMoney() {
		return this.money;
	}
	public void setPayType(Integer value) {
		this.payType = value;
	}
	
	public Integer getPayType() {
		return this.payType;
	}
	public void setTradeNo(String value) {
		this.tradeNo = value;
	}
	
	public String getTradeNo() {
		return this.tradeNo;
	}
	public void setValidDays(Integer value) {
		this.validDays = value;
	}
	
	public Integer getValidDays() {
		return this.validDays;
	}
	public void setOpenId(String value) {
		this.openId = value;
	}
	
	public String getOpenId() {
		return this.openId;
	}
	public void setOutTradeNo(String value) {
		this.outTradeNo = value;
	}
	
	public String getOutTradeNo() {
		return this.outTradeNo;
	}
	public void setIp(String value) {
		this.ip = value;
	}
	
	public String getIp() {
		return this.ip;
	}
	public void setPayer(String value) {
		this.payer = value;
	}
	
	public String getPayer() {
		return this.payer;
	}
	public void setState(Integer value) {
		this.state = value;
	}
	
	public Integer getState() {
		return this.state;
	}
	public void setCauses(String value) {
		this.causes = value;
	}
	
	public String getCauses() {
		return this.causes;
	}
	public void setAid(String value) {
		this.aid = value;
	}
	
	public String getAid() {
		return this.aid;
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

