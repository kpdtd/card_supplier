package com.anl.card.persistence.po;

import java.util.*;

public class SysConfig {
	private Integer id;
	private Date createTime;
	private Date updateTime;
	private String name;
	private String value;
	private Date begintime;
	private Date endtime;
	private Integer state;
	private String memo;
	
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
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	public void setBegintime(Date value) {
		this.begintime = value;
	}
	
	public Date getBegintime() {
		return this.begintime;
	}
	public void setEndtime(Date value) {
		this.endtime = value;
	}
	
	public Date getEndtime() {
		return this.endtime;
	}
	public void setState(Integer value) {
		this.state = value;
	}
	
	public Integer getState() {
		return this.state;
	}
	public void setMemo(String value) {
		this.memo = value;
	}
	
	public String getMemo() {
		return this.memo;
	}
}

