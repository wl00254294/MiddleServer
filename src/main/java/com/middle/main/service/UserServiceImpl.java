package com.middle.main.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.middle.main.bo.User;
import com.middle.main.intf.UserService;
import com.middle.main.repos.UserRepos;

@Service
public class UserServiceImpl implements UserService{
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepos userrepos;
	
	public List<User> findUser(String username,String password)
	{
		logger.info("========check User from Database=========");
		List<User> list= new ArrayList<User>(); 
		List<Object[]> res= userrepos.findUser(username, password);
		Iterator<Object[]> it = res.iterator();
		while(it.hasNext()){
		     Object[] line = it.next();
		     User eq = new User();
	
		     eq.setUid((String) line[0]);
		     eq.setUsername((String) line[1]);
		     eq.setPassword((String) line[2]);
		     eq.setStatus((String) line[3]);
		     eq.setUp_date((Date) line[4]);		   

		     list.add(eq);
		}
		
		return list;
	}
	
	public List<User> findUserByToken(String token)
	{
		String user=""; 
		//user=JWT.decode(token).getAudience().get(0);
		logger.info("User====>"+user);
		String username=JWT.decode(token).getClaim("username").asString();
		String password=JWT.decode(token).getClaim("password").asString();
		
		//StringTokenizer st = new StringTokenizer(user, "|");
		//int n=0;
		//while (st.hasMoreTokens()){
			
		//	if(n==0)
		//	{
		//		username=st.nextToken();
		//		logger.info("User====>"+username);
		//	}else{
		//		password=st.nextToken();
		//		logger.info("PWD====>"+password);
		//	}
		//	n++;
		//}
		
		logger.info("========check User from Database=========");
		List<User> list= new ArrayList<User>(); 
		List<Object[]> res= userrepos.findUser(username, password);
		Iterator<Object[]> it = res.iterator();
		while(it.hasNext()){
		     Object[] line = it.next();
		     User eq = new User();
	
		     eq.setUid((String) line[0]);
		     eq.setUsername((String) line[1]);
		     eq.setPassword((String) line[2]);
		     eq.setStatus((String) line[3]);
		     eq.setUp_date((Date) line[4]);		   

		     list.add(eq);
		}
		
		return list;
		
		
	}

}
