
package com.anl.card.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anl.card.persistence.mapper.OrderOperationRecordMapper;
import com.anl.card.persistence.po.OrderOperationRecord;

@Service
public class OrderOperationRecordServiceImpl implements OrderOperationRecordService {

	@Autowired
	OrderOperationRecordMapper orderOperationRecordMapper;
	
	@Override
	public int insert(OrderOperationRecord record) throws SQLException {
		return orderOperationRecordMapper.insert(record);
	}

	@Override
	public int update(OrderOperationRecord record) throws SQLException {
		return orderOperationRecordMapper.update(record);
	}

	@Override
	public int deleteById(Integer id) throws SQLException {
		return orderOperationRecordMapper.deleteById(id);
	}

	@Override
	public OrderOperationRecord getById(Integer id) throws SQLException {
		return orderOperationRecordMapper.getById(id);
	}

	@Override
	public List<OrderOperationRecord> getListByMap(Map<String, Object> condition) throws SQLException {
		return orderOperationRecordMapper.getListByMap(condition);
	}
	
	@Override
	public List<OrderOperationRecord> getListByPo(OrderOperationRecord record) throws SQLException {
		return orderOperationRecordMapper.getListByPo(record);
	}

	@Override
	public int count(Map<String, Object> condition) throws SQLException {
		return orderOperationRecordMapper.count(condition);
	}
	
}

