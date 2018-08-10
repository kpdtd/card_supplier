package com.anl.card.persistence.po;

import java.util.*;

public class CardBatchProcess {
	private Integer id;
	private String code;
	private String action;
	private Integer number;
	private String filePath;
	private String operator;
	private String comment;
	private Date startTime;
	private Date endTime;
	private Integer state;
	private Date createTime;
	
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setCode(String value) {
		this.code = value;
	}
	
	public String getCode() {
		return this.code;
	}
	public void setAction(String value) {
		this.action = value;
	}
	
	public String getAction() {
		return this.action;
	}
	public void setNumber(Integer value) {
		this.number = value;
	}
	
	public Integer getNumber() {
		return this.number;
	}
	public void setFilePath(String value) {
		this.filePath = value;
	}
	
	public String getFilePath() {
		return this.filePath;
	}
	public void setOperator(String value) {
		this.operator = value;
	}
	
	public String getOperator() {
		return this.operator;
	}
	public void setComment(String value) {
		this.comment = value;
	}
	
	public String getComment() {
		return this.comment;
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
}

