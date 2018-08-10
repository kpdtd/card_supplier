package com.anl.card.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

@Service
public class RedisFactory {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	public void set(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}

	public void update(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}

	public void delete(String key) {
		redisTemplate.delete(key);
	}

	public void incre(String key, long delta) {
		redisTemplate.opsForValue().increment(key, delta);
	}

	public void expireAt(String key, Date date) {
		redisTemplate.expireAt(key, date);
	}

	public void publish(String channel, Object message) {
		redisTemplate.convertAndSend(channel, message);
	}

	public Object get(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	public Set<Object> getSet(String key) {
		return redisTemplate.opsForSet().members(key);
	}

	public Object leftPop(String key) {
		return redisTemplate.opsForList().leftPop(key);
	}

	public Object leftPush(String key, Object message) {
		return redisTemplate.opsForList().leftPush(key, message);
	}

	public Object rightPop(String key) {
		return redisTemplate.opsForList().rightPop(key);
	}

	public Object rightPush(String key, Object message) {
		return redisTemplate.opsForList().rightPush(key, message);
	}

	public long llen(String key) {
		return redisTemplate.opsForList().size(key);
	}

	public void flushDB() {
		redisTemplate.getConnectionFactory().getConnection().flushDb();
	}

}
