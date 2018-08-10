package com.anl.card.persistence.po;

import java.util.*;

public class User {
	private Integer id;
	private String indentity;
	private String username;
	private String password;
	private String phone;
	private String wxOpenid;
	private Integer cardId;
	private String iccid;
	private Integer channelId;
	private Date createTime;
	private Date updateTime;
	
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setIndentity(String value) {
		this.indentity = value;
	}
	
	public String getIndentity() {
		return this.indentity;
	}
	public void setUsername(String value) {
		this.username = value;
	}
	
	public String getUsername() {
		return this.username;
	}
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setPhone(String value) {
		this.phone = value;
	}
	
	public String getPhone() {
		return this.phone;
	}
	public void setWxOpenid(String value) {
		this.wxOpenid = value;
	}
	
	public String getWxOpenid() {
		return this.wxOpenid;
	}
	public void setCardId(Integer value) {
		this.cardId = value;
	}
	
	public Integer getCardId() {
		return this.cardId;
	}
	public void setIccid(String value) {
		this.iccid = value;
	}
	
	public String getIccid() {
		return this.iccid;
	}
	public void setChannelId(Integer value) {
		this.channelId = value;
	}
	
	public Integer getChannelId() {
		return this.channelId;
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

