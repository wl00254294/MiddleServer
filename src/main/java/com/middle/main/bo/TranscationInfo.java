package com.middle.main.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//for dashboard.html transcation records
@ApiModel(description ="額度轉換資訊Entity")
public class TranscationInfo {
	
	@ApiModelProperty("編號")
	private String orderno;
	
	@ApiModelProperty("狀態")
	private String state;
	
	
	private String operator;
	private String locate;
	private String distance;
	private String sdt;
	private String due;
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getLocate() {
		return locate;
	}
	public void setLocate(String locate) {
		this.locate = locate;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDue() {
		return due;
	}
	public void setDue(String due) {
		this.due = due;
	}
	

}
