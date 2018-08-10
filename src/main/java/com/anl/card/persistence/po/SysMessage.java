package com.anl.card.persistence.po;

import java.util.*;

public class SysMessage {
	private Integer id;
	private Date createTime;
	private Date updateTime;
	private String title;
	private String content;
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
	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}
	public void setTitle(String value) {
		this.title = value;
	}
	
	public String getTitle() {
		return this.title;
	}
	public void setContent(String value) {
		this.content = value;
	}
	
	public String getContent() {
		return this.content;
	}
	public void setStatus(Boolean value) {
		this.status = value;
	}
	
	public Boolean getStatus() {
		return this.status;
	}
}

