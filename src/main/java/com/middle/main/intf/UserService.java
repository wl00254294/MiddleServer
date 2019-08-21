package com.middle.main.intf;

import java.util.List;

import com.middle.main.bo.User;



public interface UserService {

	public List<User> findUser(String username,String password);
	public List<User> findUserByToken(String token);
}
