package com.middle.main.intf;

import java.util.List;

import com.middle.main.bo.CostData;
import com.middle.main.bo.MonthData;
import com.middle.main.bo.WeekData;

public interface ReportService {
	
	public List<WeekData> getWeekData( String username);
	public List<MonthData> getMonthData( String username);
	public List<CostData> getCostData( String username);

}
