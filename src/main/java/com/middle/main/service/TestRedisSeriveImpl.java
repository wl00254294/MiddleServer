package com.middle.main.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;



@Service
public class TestRedisSeriveImpl {

	@Cacheable(value = "getLongRunningTaskResult", key="{#seconds}", cacheManager = "cacheManager1Hour")
	public long getLongRunningTaskResult(long seconds) {
		return seconds;
	}
}
