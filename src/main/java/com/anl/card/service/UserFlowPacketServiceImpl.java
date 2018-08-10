
package com.anl.card.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anl.card.persistence.mapper.UserFlowPacketMapper;
import com.anl.card.persistence.po.UserFlowPacket;

@Service
public class UserFlowPacketServiceImpl implements UserFlowPacketService {

	@Autowired
	UserFlowPacketMapper userFlowPacketMapper;
	
	@Override
	public int insert(UserFlowPacket record) throws SQLException {
		return userFlowPacketMapper.insert(record);
	}

	@Override
	public int update(UserFlowPacket record) throws SQLException {
		return userFlowPacketMapper.update(record);
	}

	@Override
	public int deleteById(Integer id) throws SQLException {
		return userFlowPacketMapper.deleteById(id);
	}

	@Override
	public UserFlowPacket getById(Integer id) throws SQLException {
		return userFlowPacketMapper.getById(id);
	}

	@Override
	public List<UserFlowPacket> getListByMap(Map<String, Object> condition) throws SQLException {
		return userFlowPacketMapper.getListByMap(condition);
	}
	
	@Override
	public List<UserFlowPacket> getListByPo(UserFlowPacket record) throws SQLException {
		return userFlowPacketMapper.getListByPo(record);
	}

	@Override
	public int count(Map<String, Object> condition) throws SQLException {
		return userFlowPacketMapper.count(condition);
	}
	
}

