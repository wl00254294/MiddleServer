package com.middle.main.restcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.middle.main.annotation.RequestLimit;
import com.middle.main.bo.Data;
import com.middle.main.bo.NotifyInfo;
import com.middle.main.bo.TranscationInfo;
import com.middle.main.service.NotifyServiceImpl;
import com.middle.main.service.TransServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "儀表板相關API", description = "提供儀表板相關的 Rest API")
public class DashboardContrl {
	private static final Logger logger = LoggerFactory.getLogger(DashboardContrl.class);
	@Autowired
	private TransServiceImpl trans;
	
	@Autowired
	private NotifyServiceImpl notify;
	
	
	@ApiOperation("取得使用者交易資訊")
	@RequestLimit(count=10,time=120*1000)
	@RequestMapping(value="/getTransInfo", method = RequestMethod.POST)
	public List<TranscationInfo>  getrnsinfo(HttpServletRequest request, HttpSession session,
			HttpServletResponse response,
			@RequestBody String username) 
	{
		logger.info("getTransInfo called from =====>"+request.getRemoteAddr());
		
		List<TranscationInfo> out =trans.getTransInfo(username);
		
		return out;
	}
	
	@ApiOperation("提醒使用者交易備註")
	@RequestLimit(count=10,time=120*1000)
	@RequestMapping(value="/getNoteInfo", method = RequestMethod.POST)
	public List<NotifyInfo>  getnoticeinfo(HttpServletRequest request, HttpSession session,
			HttpServletResponse response,
			@RequestBody String username)
	{
		logger.info("getNoteInfo called from =====>"+request.getRemoteAddr());
		List<NotifyInfo> out = notify.getNotifyInfo(username);
		
		return out;
	}
	
	@RequestLimit(count=10,time=120*1000)
	@RequestMapping(value="/test", method = RequestMethod.POST)
	public Data  test2(HttpServletRequest request, HttpSession session,
			HttpServletResponse response,@RequestBody Data data) 
	{
		return data;
	}
}
