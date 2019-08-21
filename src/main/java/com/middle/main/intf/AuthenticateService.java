package com.middle.main.intf;

import com.middle.main.bo.User;

public interface AuthenticateService {
	
	public String getToken(User user);
	
	public boolean verifyToken(String token);
	
	public boolean refrshable(String token);
	

}
