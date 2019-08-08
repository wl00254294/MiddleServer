package com.middle.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.middle.main.bo.NotifyInfo;
import com.middle.main.intf.NotifyService;


@Service
public class NotifyServiceImpl implements NotifyService{
	
	public List<NotifyInfo> getNotifyInfo( String username)
	{
		List<NotifyInfo> list=new ArrayList<NotifyInfo>();
		if("admin".equals(username))
		{
			for(int i=0;i<5;i++)
			{
				NotifyInfo notify=new NotifyInfo();
				notify.setPlateform("Plateform"+Integer.toString((i+1)));
				notify.setMessage("You receive message from "+ Integer.toString(i+1));
				notify.setTransdate("2018-07-22");
				list.add(notify);
			}
		}
		return list;
	}

}
