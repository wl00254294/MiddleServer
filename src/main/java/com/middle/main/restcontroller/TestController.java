package com.middle.main.restcontroller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.middle.main.annotation.RequestLimit;
import com.middle.main.bo.Data;
import com.middle.main.bo.User;
import com.middle.main.service.AuthenticateServiceImpl;
import com.middle.main.service.UserServiceImpl;



@RestController
public class TestController {

	@Autowired
	private AuthenticateServiceImpl auth;
	
	@Autowired
	private UserServiceImpl userservice;
	
	@RequestMapping(value="/mytest", method = RequestMethod.POST)
	public String  getrnsinfo(HttpServletRequest request, HttpSession session,
			HttpServletResponse response,
			@RequestBody Data data) 
	{
		String a=request.getParameter("test");
		return data.getRate()+"|"+a;
	}
	
		
	@RequestLimit(count=10,time=120*1000)
	@RequestMapping(value="/compare", method = RequestMethod.POST)
	public List<User>  getheadero(HttpServletRequest request, HttpSession session,
			HttpServletResponse response,@RequestHeader HttpHeaders headers) 
	{
		String token= request.getParameter("token");
		List<User> out = userservice.findUserByToken(token);
		
		return out;
	}	
	
	@RequestMapping(value="/getexp", method = RequestMethod.POST)
	public String  getheadero2(HttpServletRequest request, HttpSession session,
			HttpServletResponse response,@RequestHeader HttpHeaders headers) 
	{
		String token= request.getParameter("token");
		String ty="";
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if("token".equals(cookie.getName()))
    	        {
					ty=cookie.getValue();
    	        }
			}
		}
		
		DecodedJWT jwt = JWT.decode(token);
		
		
		
		return ty+"========"+jwt.getClaim("expiration").asString();
	}	
}
