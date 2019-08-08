package com.middle.main.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.middle.main.service.TestRedisSeriveImpl;

@RestController
public class TestRedisController {
	private static final Logger logger = LoggerFactory.getLogger(TestRedisController.class);
	@Autowired
	private TestRedisSeriveImpl test;
	
	@RequestMapping(value = "/{seconds}", method = RequestMethod.GET)
	public long longRunningTask(@PathVariable long seconds) {
		
	    long out=test.getLongRunningTaskResult(seconds);
	    
	    return out*100;
	}
}
