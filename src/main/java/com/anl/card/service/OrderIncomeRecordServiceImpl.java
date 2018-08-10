
package com.anl.card.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anl.card.persistence.mapper.OrderIncomeRecordMapper;
import com.anl.card.persistence.po.OrderIncomeRecord;

@Service
public class OrderIncomeRecordServiceImpl implements OrderIncomeRecordService {

	@Autowired
	OrderIncomeRecordMapper orderIncomeRecordMapper;
	
	@Override
	public int insert(OrderIncomeRecord record) throws SQLException {
		return orderIncomeRecordMapper.insert(record);
	}

	@Override
	public int update(OrderIncomeRecord record) throws SQLException {
		return orderIncomeRecordMapper.update(record);
	}

	@Override
	public int deleteById(Integer id) throws SQLException {
		return orderIncomeRecordMapper.deleteById(id);
	}

	@Override
	public OrderIncomeRecord getById(Integer id) throws SQLException {
		return orderIncomeRecordMapper.getById(id);
	}

	@Override
	public List<OrderIncomeRecord> getListByMap(Map<String, Object> condition) throws SQLException {
		return orderIncomeRecordMapper.getListByMap(condition);
	}
	
	@Override
	public List<OrderIncomeRecord> getListByPo(OrderIncomeRecord record) throws SQLException {
		return orderIncomeRecordMapper.getListByPo(record);
	}

	@Override
	public int count(Map<String, Object> condition) throws SQLException {
		return orderIncomeRecordMapper.count(condition);
	}
	
}

