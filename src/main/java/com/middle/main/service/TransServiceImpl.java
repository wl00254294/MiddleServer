package com.middle.main.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.middle.main.bo.TranscationInfo;
import com.middle.main.intf.TransService;

@Service
public class TransServiceImpl implements TransService {
	private static final Logger logger = LoggerFactory.getLogger(TransServiceImpl.class);
	
	public List<TranscationInfo> getTransInfo(String username)
	{
		logger.info("====call getTransInfo Service====");
		List<TranscationInfo> list=new ArrayList<TranscationInfo>();
		//if("admin".equals(username))
		//{
			for(int i=0;i<14;i++)
			{
				TranscationInfo tif=new TranscationInfo();
				tif.setOrderno("#1234");
				if(i==0)
				{
					tif.setState("Finish");
				}else if(i==1)
				{
					tif.setState("Pend");
				}else
				{
					tif.setState("Cancle");
				}
				tif.setOperator("Admin");
				tif.setLocate("Tawian");
				tif.setDistance(Integer.toString((i+1)*10)+ " km");
				tif.setSdt("2019-01-01");
				tif.setDue("2019-08-09");
				list.add(tif);
			}
		//}
		return list;
	}

}
