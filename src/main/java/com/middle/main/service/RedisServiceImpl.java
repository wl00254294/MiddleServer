package com.middle.main.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import com.middle.main.intf.RedisService;


@Service
public class RedisServiceImpl implements RedisService{
	
	private static final Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

	@Resource
	private RedisTemplate<String,Object> redisTemplate;
	
	public void set(String key, Object value)
	{
		logger.info("====Redis set value");
		RedisSerializer redisSerializer =new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        vo.set(key, value);

	}
	public Object get(String key)
	{
		logger.info("====Redis get value");
		ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        return vo.get(key);

	}
	public void delete(String key)
	{
		logger.info("====Redis delete Key");
		redisTemplate.delete(key);
	}
}
