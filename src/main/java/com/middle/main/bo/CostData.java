package com.middle.main.bo;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description ="消費資料Entity")
public class CostData {
 
@ApiModelProperty("平台名稱")
 private String platename;

@ApiModelProperty("消費細節")
 List<CostInfo> info;
 
 
public String getPlatename() {
	return platename;
}
public void setPlatename(String platename) {
	this.platename = platename;
}
public List<CostInfo> getInfo() {
	return info;
}
public void setInfo(List<CostInfo> info) {
	this.info = info;
}
 
 
}
