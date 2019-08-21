package com.middle.main.aop;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.middle.main.annotation.RequestLimit;
import com.middle.main.bo.User;
import com.middle.main.exception.RequestLimitException;
import com.middle.main.function.JacksonUtil;
import com.middle.main.service.RedisServiceImpl;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class RequestLimitContract {
	@Autowired
	private RedisServiceImpl redis;
	
	@Pointcut("execution(* com.middle.main.restcontroller ..*(..) )")
	public void servicePointcut(){
		
	}
	
	 @Before("servicePointcut()")
	 public void before(JoinPoint joinPoint) throws RequestLimitException {
	 	
	   
	   
	   String remoteAddress = ((ServletRequestAttributes) RequestContextHolder
	                .currentRequestAttributes()).getRequest().getRemoteAddr();
	 
	   
	
	   String username="";
	   
	   
	   MethodSignature signature = (MethodSignature) joinPoint.getSignature();
	   Method method = signature.getMethod();
	   
	   String method_name=method.getName();
	   
	   if("getToken".equals(method_name))
	   {
		   Object[] args = joinPoint.getArgs();
		   User user=(User) args[3];
		   username=user.getUsername();
		 
	   }
	   
	   String key=method_name+"@"+remoteAddress+"@"+username;
	   

 
	   RequestLimit action = method.getAnnotation(RequestLimit.class);
	   
	 
	   System.out.print("BEFORE");
	   //|| (int)redis.get(key)==0
	   if(redis.get(key)==null )
	   {
		   redis.set(key, 1);
           Timer timer= new Timer();
           TimerTask task = new TimerTask(){
               @Override  
               public void run() { 
                redis.delete(key); 
               }
           };  
           timer.schedule(task, action.time()); 
		   
	   }else
       {  
           redis.set(key,(int)redis.get(key)+1);  
       }  
	   
	   int count = (int)redis.get(key);
	   
	   
	   if (count > action.count())
	   {
		   throw new RequestLimitException();
	   }
	   
	   
	 }
	 

}
