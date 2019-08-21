package com.middle.main.intf;


public interface RedisService {
	public void set(String key, Object value);
	public Object get(String key);
	public void delete(String key);
}
