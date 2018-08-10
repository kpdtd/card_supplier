package com.anl.card.persistence.po;

import java.util.*;

public class UserFlowPacket {
	private Integer id;
	private Integer userId;
	private Integer flow;
	private Integer packetId;
	private String packetName;
	private Integer balance;
	private String source;
	private Integer state;
	private Date startTime;
	private Date endTime;
	private Date createTime;
	private Date updateTime;
	
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setUserId(Integer value) {
		this.userId = value;
	}
	
	public Integer getUserId() {
		return this.userId;
	}
	public void setFlow(Integer value) {
		this.flow = value;
	}
	
	public Integer getFlow() {
		return this.flow;
	}
	public void setPacketId(Integer value) {
		this.packetId = value;
	}
	
	public Integer getPacketId() {
		return this.packetId;
	}
	public void setPacketName(String value) {
		this.packetName = value;
	}
	
	public String getPacketName() {
		return this.packetName;
	}
	public void setBalance(Integer value) {
		this.balance = value;
	}
	
	public Integer getBalance() {
		return this.balance;
	}
	public void setSource(String value) {
		this.source = value;
	}
	
	public String getSource() {
		return this.source;
	}
	public void setState(Integer value) {
		this.state = value;
	}
	
	public Integer getState() {
		return this.state;
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
	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}
}

