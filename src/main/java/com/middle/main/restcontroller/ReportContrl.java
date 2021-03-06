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
import com.middle.main.bo.CostData;
import com.middle.main.bo.MonthData;
import com.middle.main.bo.TranscationInfo;
import com.middle.main.bo.WeekData;
import com.middle.main.service.ReportServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "報表相關API", description = "提供報表相關的 Rest API")
public class ReportContrl {
	
	private static final Logger logger = LoggerFactory.getLogger(ReportContrl.class);
	
	@Autowired
	private ReportServiceImpl report;
	
	@ApiOperation("取得使用者上/本周各平台點數資訊")
	@RequestLimit(count=10,time=120*1000)
	@RequestMapping(value="/getWeekData", method = RequestMethod.POST)
	public List<WeekData>  getweekdata(HttpServletRequest request, HttpSession session,
			HttpServletResponse response,
			@RequestBody String username) 
	{
		logger.info("getWeekData called from =====>"+request.getRemoteAddr());
		
		List<WeekData> out =report.getWeekData(username);
		
		return out;
	}
	
	@ApiOperation("取得使用者上/本月各平台點數資訊")
	@RequestLimit(count=10,time=120*1000)
	@RequestMapping(value="/getMonthData", method = RequestMethod.POST)
	public List<MonthData>  getmonthdata(HttpServletRequest request, HttpSession session,
			HttpServletResponse response,
			@RequestBody String username) 
	{
		logger.info("getMonthData called from =====>"+request.getRemoteAddr());
		
		List<MonthData> out =report.getMonthData(username);
		
		return out;
	}
	
	@ApiOperation("取得使用者各平台點數消費狀況")
	@RequestLimit(count=10,time=120*1000)
	@RequestMapping(value="/getCostData", method = RequestMethod.POST)
	public List<CostData>  getcostdata( HttpServletRequest request,HttpSession session,
			HttpServletResponse response,
			@RequestBody String username)
	{
		
		logger.info("getCostData called from =====>"+request.getRemoteAddr());
		List<CostData> out = report.getCostData(username);
		
		return out;
	}

}
