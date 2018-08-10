package com.anl.card.persistence.po;

import java.util.*;

public class AutoTaskExecHistory {
	private Integer id;
	private Integer taskId;
	private String category;
	private Integer itemTotal;
	private Integer itemSuccess;
	private Integer returnResult;
	private Date startTime;
	private Date endTime;
	private Date createTime;
	
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setTaskId(Integer value) {
		this.taskId = value;
	}
	
	public Integer getTaskId() {
		return this.taskId;
	}
	public void setCategory(String value) {
		this.category = value;
	}
	
	public String getCategory() {
		return this.category;
	}
	public void setItemTotal(Integer value) {
		this.itemTotal = value;
	}
	
	public Integer getItemTotal() {
		return this.itemTotal;
	}
	public void setItemSuccess(Integer value) {
		this.itemSuccess = value;
	}
	
	public Integer getItemSuccess() {
		return this.itemSuccess;
	}
	public void setReturnResult(Integer value) {
		this.returnResult = value;
	}
	
	public Integer getReturnResult() {
		return this.returnResult;
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

