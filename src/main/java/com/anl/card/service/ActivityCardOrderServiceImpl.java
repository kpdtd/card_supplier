
package com.anl.card.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anl.card.persistence.mapper.ActivityCardOrderMapper;
import com.anl.card.persistence.po.ActivityCardOrder;

@Service
public class ActivityCardOrderServiceImpl implements ActivityCardOrderService {

	@Autowired
	ActivityCardOrderMapper activityCardOrderMapper;
	
	@Override
	public int insert(ActivityCardOrder record) throws SQLException {
		return activityCardOrderMapper.insert(record);
	}

	@Override
	public int update(ActivityCardOrder record) throws SQLException {
		return activityCardOrderMapper.update(record);
	}

	@Override
	public int deleteById(Integer id) throws SQLException {
		return activityCardOrderMapper.deleteById(id);
	}

	@Override
	public ActivityCardOrder getById(Integer id) throws SQLException {
		return activityCardOrderMapper.getById(id);
	}

	@Override
	public List<ActivityCardOrder> getListByMap(Map<String, Object> condition) throws SQLException {
		return activityCardOrderMapper.getListByMap(condition);
	}
	
	@Override
	public List<ActivityCardOrder> getListByPo(ActivityCardOrder record) throws SQLException {
		return activityCardOrderMapper.getListByPo(record);
	}

	@Override
	public int count(Map<String, Object> condition) throws SQLException {
		return activityCardOrderMapper.count(condition);
	}
	
}

