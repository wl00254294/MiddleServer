package com.middle.main.config;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.auth0.jwt.JWT;
import com.middle.main.bo.User;
import com.middle.main.service.AuthenticateServiceImpl;
import com.middle.main.service.UserServiceImpl;


@Component
public class SessionInterceptor implements HandlerInterceptor{
	
    
	
	private static final Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);
	
	@Autowired
	private AuthenticateServiceImpl auth;
	
	 @Override
	    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		 	logger.info("=====start session preHandle!");
		    String uri = request.getRequestURI();
	       // HttpSession session = request.getSession();
	        //String token=(String) session.getAttribute("token");
		    
	        if (uri.endsWith("/gettoken") ) {
	            return true;
	        }
        	
	        String token = request.getParameter("token");
	        
	        
	       if ( token != null )
	        {
	    	   //String reqtoken=request.getParameter("token");
	    	   logger.info("TOKEN=====>"+token);				
	    	   
	    	   
				if(auth.verifyToken(token))
				{
					return true;
				}
	    	   
	    	   
	        }
	       
	        response.setStatus(403);
	        
	      
   		 
	        return false;
	    }
	 
	 @Override
	    public void postHandle(HttpServletRequest request,
	                           HttpServletResponse response, Object handler,
	                           ModelAndView modelAndView) throws Exception {
	    }
	 
	 @Override
	    public void afterCompletion(HttpServletRequest request,
	                                HttpServletResponse response, Object handler, Exception ex)
	            throws Exception {

	    }
}
