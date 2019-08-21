package com.middle.main.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;



@Service
public class TestRedisSeriveImpl {
	private static final Logger logger = LoggerFactory.getLogger(TestRedisSeriveImpl.class);
	@Cacheable(value = "getLongRunningTaskResult", key="{#seconds}", cacheManager = "cacheManager1Hour")
	public long getLongRunningTaskResult(long seconds) {
		
		logger.info("=================CALL SECONDS");
		return seconds;
	}
}