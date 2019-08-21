package com.middle.main.restcontroller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.middle.main.annotation.RequestLimit;
import com.middle.main.bo.Token;
import com.middle.main.bo.User;
import com.middle.main.service.AuthenticateServiceImpl;
import com.middle.main.service.RedisServiceImpl;
import com.middle.main.service.UserServiceImpl;

@RestController
public class AuthenticateContrl {

	@Autowired
	private AuthenticateServiceImpl auth;
	
	@Autowired
	private UserServiceImpl userservice;
	
	@Autowired
	private RedisServiceImpl redis;
	
	
	@RequestLimit(count=10,time=120*1000)
	@RequestMapping(value="/gettoken", method = RequestMethod.POST)
	public String  getToken(HttpServletRequest request, HttpSession session,
			HttpServletResponse response,
			@RequestBody User user) throws Exception 
	{
		String token="";
		String username="";
		
	
		
		String remoteAddress=request.getRemoteAddr();
		
		username=user.getUsername();
		String password=user.getPassword();
		
		String acesskey="getToken@"+remoteAddress+"@"+username;
		System.out.println("AccessKey=========="+acesskey);
		
		
		
		if(redis.get(acesskey)!=null )
		{
			if((int)redis.get(acesskey) >1)
			{
				return "You have to get Token after 2 mins";
			}
		}
		
		
		//if(redis.get(acesskey)!=null && (boolean)redis.get(acesskey) )
		//{
		//	return "You have to get Token after 2 mins";
		//}
		
		
		List<User> result = userservice.findUser(username, password);
		
		if(result.size()>0)
		{
			
			token=auth.getToken(user);
			
			//Cookie rescookie = new Cookie("token", token);
			//Cookie rescookie2 = new Cookie("username", username);
            //response.addCookie(rescookie);
            //response.addCookie(rescookie2);
			return token;
		}
	
		
		return "Invalid Username or Password";
	}
}
