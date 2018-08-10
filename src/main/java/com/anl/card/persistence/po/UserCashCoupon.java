package com.anl.card.persistence.po;

import java.util.*;

public class UserCashCoupon {
	private Integer id;
	private Integer cashCouponId;
	private String title;
	private Integer type;
	private Integer faceValue;
	private Date startDate;
	private Date endDate;
	private Integer state;
	private String source;
	private Date createTime;
	private Date updateTime;
	
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setCashCouponId(Integer value) {
		this.cashCouponId = value;
	}
	
	public Integer getCashCouponId() {
		return this.cashCouponId;
	}
	public void setTitle(String value) {
		this.title = value;
	}
	
	public String getTitle() {
		return this.title;
	}
	public void setType(Integer value) {
		this.type = value;
	}
	
	public Integer getType() {
		return this.type;
	}
	public void setFaceValue(Integer value) {
		this.faceValue = value;
	}
	
	public Integer getFaceValue() {
		return this.faceValue;
	}
	public void setStartDate(Date value) {
		this.startDate = value;
	}
	
	public Date getStartDate() {
		return this.startDate;
	}
	public void setEndDate(Date value) {
		this.endDate = value;
	}
	
	public Date getEndDate() {
		return this.endDate;
	}
	public void setState(Integer value) {
		this.state = value;
	}
	
	public Integer getState() {
		return this.state;
	}
	public void setSource(String value) {
		this.source = value;
	}
	
	public String getSource() {
		return this.source;
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

