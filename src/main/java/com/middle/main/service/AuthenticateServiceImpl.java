package com.middle.main.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.middle.main.annotation.RequestLimit;
import com.middle.main.bo.User;
import com.middle.main.intf.AuthenticateService;


@Service
public class AuthenticateServiceImpl implements AuthenticateService{
	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticateServiceImpl.class);
	@Autowired
	private UserServiceImpl userservice;
	
	public String getToken(User user)
	{
		logger.info("======Token is Created=========");		
		Date date = new Date(System.currentTimeMillis() + 2*60*1000);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = formatter.format(date);
        String token="";
        String key= RandomStringUtils.random(15, true, true);
        //.withAudience(username)
        token= JWT.create().withClaim("username", user.getUsername())
        		.withClaim("password", user.getPassword())
        		.withClaim("expiration", format)
        		.withExpiresAt(date)
                .sign(Algorithm.HMAC256(key));
        return token;
	}
	
	
	
	//@Cacheable(value = "getLongRunningTaskResult", key="{#seconds}", cacheManager = "cacheManager1Hour")
	public boolean verifyToken(String token) 
	{
		logger.info("======Token verify=========");
		  
		if(token == null||token.isEmpty())
		{
			logger.info("======Token is empty=========");
			return false;
		}
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String expir = JWT.decode(token).getClaim("expiration").asString();
		try {
			Date nowdate = new Date(System.currentTimeMillis());
			Date expirdate = formatter.parse(expir);
			
			if(nowdate.after(expirdate))
			{
				logger.info("======Token is expired=========");
				return false;
			}
			
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		
		try{
			//user=JWT.decode(token).getAudience().get(0);
			
			logger.info("User====info");
			String username=JWT.decode(token).getClaim("username").asString();
			String password=JWT.decode(token).getClaim("password").asString();
	
			List<User> result = userservice.findUser(username, password);
			if(result.size() == 0)
			{
				logger.info("======Token username is invalid=========");
				return false;
			}
			
		}catch(Exception e)
		{
			logger.info("======Token can not be decode =========");
			return false;
		}
		
		return true;
	}
	
	public boolean refrshable(String token)
	{
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String expir = JWT.decode(token).getClaim("expiration").asString();
		Date nowdate = new Date(System.currentTimeMillis());
		try {
			Date expirdate = formatter.parse(expir);
		    if(nowdate.after(expirdate))
		    {
		    	logger.info("======Token can be Refresh =========");
		    	return true;
		    }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info("======Token can be Refrsh after 2 mins =========");
		return false;
	}

}
