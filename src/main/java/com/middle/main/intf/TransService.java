package com.middle.main.intf;

import java.util.List;

import com.middle.main.bo.TranscationInfo;

public interface TransService {

	public List<TranscationInfo> getTransInfo( String username);
}
