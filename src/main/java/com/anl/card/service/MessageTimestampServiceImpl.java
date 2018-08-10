
package com.anl.card.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anl.card.persistence.mapper.MessageTimestampMapper;
import com.anl.card.persistence.po.MessageTimestamp;

@Service
public class MessageTimestampServiceImpl implements MessageTimestampService {

	@Autowired
	MessageTimestampMapper messageTimestampMapper;
	
	@Override
	public int insert(MessageTimestamp record) throws SQLException {
		return messageTimestampMapper.insert(record);
	}

	@Override
	public int update(MessageTimestamp record) throws SQLException {
		return messageTimestampMapper.update(record);
	}

	@Override
	public int deleteById(Integer id) throws SQLException {
		return messageTimestampMapper.deleteById(id);
	}

	@Override
	public MessageTimestamp getById(Integer id) throws SQLException {
		return messageTimestampMapper.getById(id);
	}

	@Override
	public List<MessageTimestamp> getListByMap(Map<String, Object> condition) throws SQLException {
		return messageTimestampMapper.getListByMap(condition);
	}
	
	@Override
	public List<MessageTimestamp> getListByPo(MessageTimestamp record) throws SQLException {
		return messageTimestampMapper.getListByPo(record);
	}

	@Override
	public int count(Map<String, Object> condition) throws SQLException {
		return messageTimestampMapper.count(condition);
	}
	
}

