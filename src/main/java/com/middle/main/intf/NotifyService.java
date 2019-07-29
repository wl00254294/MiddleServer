package com.middle.main.intf;

import java.util.List;

import com.middle.main.bo.NotifyInfo;


public interface NotifyService {
	public List<NotifyInfo> getNotifyInfo( String username);
}
