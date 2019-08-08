package com.middle.main.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.middle.main.bo.CostData;
import com.middle.main.bo.CostInfo;
import com.middle.main.bo.Data;
import com.middle.main.bo.MonthData;
import com.middle.main.bo.WeekData;
import com.middle.main.intf.ReportService;


@Service
public class ReportServiceImpl implements ReportService{
		
	private static final Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);
	
	public List<WeekData> getWeekData( String username)
	{
		logger.info("======call getWeekData Service=====");
		List<WeekData> list =new ArrayList<WeekData>();
		for(int i=0;i<6;i++)
		{
			
			WeekData week=new WeekData();
			List<Data> k=new ArrayList<Data>();
			for(int j=0;j<2;j++)
			{
				Data tmp=new Data();
				if(j==0)
				{
					tmp.setValue((j+i+1)*10);
					tmp.setRate("本周");
				}else if(j==1){
					tmp.setValue((j+i+1)*10);
					tmp.setRate("上周");					
				}
				k.add(tmp);
			}
			
			week.setValues(k);
			week.setCategorie("Plate"+Integer.toString((i+1)));
			list.add(week);
			
		}
		
		return list;
	}
	public List<MonthData> getMonthData( String username)
	{
		logger.info("======call getMonthData Service=====");
		List<MonthData> list =new ArrayList<MonthData>();
		for(int i=0;i<6;i++)
		{
			
			MonthData month=new MonthData();
			List<Data> k=new ArrayList<Data>();
			for(int j=0;j<2;j++)
			{
				Data tmp=new Data();
				if(j==0)
				{
					tmp.setValue((j+i+1)*10);
					tmp.setRate("本月");
				}else{
					tmp.setValue((j+i+1)*10);
					tmp.setRate("上月");					
				}
				k.add(tmp);
			}
			
			month.setValues(k);
			month.setCategorie("Plate"+Integer.toString((i+1)));
			list.add(month);
			
		}
		
		return list;
	}
	
	
	public List<CostData> getCostData( String username)
	{
       List<CostData> list=new ArrayList<CostData>();
       
       for(int i=0;i<6;i++)
       {
    	   CostData costdata = new CostData();
    	   costdata.setPlatename("Plate"+Integer.toString((i+1)));
    	   
    	   List<CostInfo> info=new ArrayList<CostInfo>();
    	   
    	   for(int j=0;j<8;j++)
    	   {
    		 CostInfo costinfo=new CostInfo();
    		 costinfo.setId(Integer.toString((j+1)));
    		 if(j ==0)
    		 {
    			 costinfo.setMap("tw"); 
    			 costinfo.setName_tw("飲食");
    			 costinfo.setName_cn("台灣");
    			 costinfo.setName_jp("台灣");
    			 costinfo.setName_en("Taiwan");
    		 } else if(j == 1)
    		 {
    			 costinfo.setMap("hk"); 
    			 costinfo.setName_tw("電玩");
    			 costinfo.setName_cn("香港");
    			 costinfo.setName_jp("香港");
    			 costinfo.setName_en("Hong Kong");    			 
    		 } else if(j == 2)
    		 {
    			 costinfo.setMap("cn"); 
    			 costinfo.setName_tw("車費");
    			 costinfo.setName_cn("中國");
    			 costinfo.setName_jp("中國");
    			 costinfo.setName_en("Chinese");
    		 }else if(j == 3)
    		 {
    			 costinfo.setMap("my"); 
    			 costinfo.setName_tw("繳稅");
    			 costinfo.setName_cn("馬國");
    			 costinfo.setName_jp("マレーシア");
    			 costinfo.setName_en("Malysia");
    		 }else if(j == 4)
    		 {
    			 costinfo.setMap("bn"); 
    			 costinfo.setName_tw("生活品");
    			 costinfo.setName_cn("文萊");
    			 costinfo.setName_jp("ブルネイ");
    			 costinfo.setName_en("Brunei");
    		 }else if(j == 5)
    		 {
    			 costinfo.setMap("sg"); 
    			 costinfo.setName_tw("應酬");
    			 costinfo.setName_cn("新加坡");
    			 costinfo.setName_jp("シンガポール");
    			 costinfo.setName_en("Singapore");
    		 }else if(j == 6)
    		 {
    			 costinfo.setMap("mo"); 
    			 costinfo.setName_tw("房租");
    			 costinfo.setName_cn("澳門");
    			 costinfo.setName_jp("マカオ");
    			 costinfo.setName_en("Macau");
    		 }else if(j == 7)
    		 {
    			 costinfo.setMap("id"); 
    			 costinfo.setName_tw("其他");
    			 costinfo.setName_cn("印尼");
    			 costinfo.setName_jp("インドネシア");
    			 costinfo.setName_en("Indonesia");
    		 }
    		 
    		 costinfo.setCount((i+1)*(j+1));
    		 costinfo.setBadge((j+1)*10);
    		 info.add(costinfo);
    	   }
    	   
    	   costdata.setInfo(info);
    	   
    	   list.add(costdata);
       }
		
		return list;
	}
}
