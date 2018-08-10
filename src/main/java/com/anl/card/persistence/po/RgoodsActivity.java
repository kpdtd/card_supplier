package com.anl.card.persistence.po;

import java.util.*;

public class RgoodsActivity {
	private Integer id;
	private Integer goodsId;
	private Integer activityId;
	private Date createTime;
	
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setGoodsId(Integer value) {
		this.goodsId = value;
	}
	
	public Integer getGoodsId() {
		return this.goodsId;
	}
	public void setActivityId(Integer value) {
		this.activityId = value;
	}
	
	public Integer getActivityId() {
		return this.activityId;
	}
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
}

