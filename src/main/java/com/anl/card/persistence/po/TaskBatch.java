package com.anl.card.persistence.po;

import java.util.*;

public class TaskBatch {
	private Integer id;
	private String taskBatchNumber;
	private String taskName;
	private String taskExecLogic;
	private String category;
	private Integer taskState;
	private Integer itemTotal;
	private Integer itemSuccess;
	private String returnResult;
	private Date startTime;
	private Date endTime;
	private Date createTime;
	
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setTaskBatchNumber(String value) {
		this.taskBatchNumber = value;
	}
	
	public String getTaskBatchNumber() {
		return this.taskBatchNumber;
	}
	public void setTaskName(String value) {
		this.taskName = value;
	}
	
	public String getTaskName() {
		return this.taskName;
	}
	public void setTaskExecLogic(String value) {
		this.taskExecLogic = value;
	}
	
	public String getTaskExecLogic() {
		return this.taskExecLogic;
	}
	public void setCategory(String value) {
		this.category = value;
	}
	
	public String getCategory() {
		return this.category;
	}
	public void setTaskState(Integer value) {
		this.taskState = value;
	}
	
	public Integer getTaskState() {
		return this.taskState;
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
	public void setReturnResult(String value) {
		this.returnResult = value;
	}
	
	public String getReturnResult() {
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

