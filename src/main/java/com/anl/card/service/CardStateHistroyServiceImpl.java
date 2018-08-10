
package com.anl.card.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anl.card.persistence.mapper.CardStateHistroyMapper;
import com.anl.card.persistence.po.CardStateHistroy;

@Service
public class CardStateHistroyServiceImpl implements CardStateHistroyService {

	@Autowired
	CardStateHistroyMapper cardStateHistroyMapper;
	
	@Override
	public int insert(CardStateHistroy record) throws SQLException {
		return cardStateHistroyMapper.insert(record);
	}

	@Override
	public int update(CardStateHistroy record) throws SQLException {
		return cardStateHistroyMapper.update(record);
	}

	@Override
	public int deleteById(Integer id) throws SQLException {
		return cardStateHistroyMapper.deleteById(id);
	}

	@Override
	public CardStateHistroy getById(Integer id) throws SQLException {
		return cardStateHistroyMapper.getById(id);
	}

	@Override
	public List<CardStateHistroy> getListByMap(Map<String, Object> condition) throws SQLException {
		return cardStateHistroyMapper.getListByMap(condition);
	}
	
	@Override
	public List<CardStateHistroy> getListByPo(CardStateHistroy record) throws SQLException {
		return cardStateHistroyMapper.getListByPo(record);
	}

	@Override
	public int count(Map<String, Object> condition) throws SQLException {
		return cardStateHistroyMapper.count(condition);
	}
	
}

