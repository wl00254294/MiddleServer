package com.middle.main.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//for dashboard.html notification
@ApiModel(description ="通知內容Entity")
public class NotifyInfo {
 
	@ApiModelProperty("平台")
	private String plateform;
	
	@ApiModelProperty("訊息")
	private String message;
	
	@ApiModelProperty("交易日期")
	private String transdate;
	
	
	public String getTransdate() {
		return transdate;
	}
	public void setTransdate(String transdate) {
		this.transdate = transdate;
	}
	public String getPlateform() {
		return plateform;
	}
	public void setPlateform(String plateform) {
		this.plateform = plateform;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
