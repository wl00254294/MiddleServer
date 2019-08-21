package com.middle.main.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description ="點數餘額Entity")
public class Data {
	
	@ApiModelProperty("餘額")
	private int value;
	
	@ApiModelProperty("第N期")
	private String rate;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	
}
