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

import com.middle.main.bo.CostData;
import com.middle.main.bo.MonthData;
import com.middle.main.bo.TranscationInfo;
import com.middle.main.bo.WeekData;
import com.middle.main.service.ReportServiceImpl;

@RestController
public class ReportContrl {
	
	private static final Logger logger = LoggerFactory.getLogger(ReportContrl.class);
	
	@Autowired
	private ReportServiceImpl report;
	
	@RequestMapping(value="/getWeekData", method = RequestMethod.POST)
	public List<WeekData>  getweekdata(HttpServletRequest request, HttpSession session,
			HttpServletResponse response,
			@RequestBody String reqdata) 
	{
		logger.info("getWeekData called from =====>"+request.getRemoteAddr());
		
		List<WeekData> out =report.getWeekData(reqdata);
		
		return out;
	}
	

	@RequestMapping(value="/getMonthData", method = RequestMethod.POST)
	public List<MonthData>  getmonthdata(HttpServletRequest request, HttpSession session,
			HttpServletResponse response,
			@RequestBody String reqdata) 
	{
		logger.info("getMonthData called from =====>"+request.getRemoteAddr());
		
		List<MonthData> out =report.getMonthData(reqdata);
		
		return out;
	}
	
	@RequestMapping(value="/getCostData", method = RequestMethod.POST)
	public List<CostData>  getcostdata(HttpServletRequest request, HttpSession session,
			HttpServletResponse response,
			@RequestBody String reqdata)
	{
		logger.info("getCostData called from =====>"+request.getRemoteAddr());
		List<CostData> out = report.getCostData(reqdata);
		
		return out;
	}

}
