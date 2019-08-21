package com.middle.main.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description ="消費細節Entity")
public class CostInfo {
	
  @ApiModelProperty("編號")
  private String id;
  
  @ApiModelProperty("消費項目簡寫")
  private String map;
  
  @ApiModelProperty("消費金額")
  private int count;
  
  @ApiModelProperty("目前暫留")
  private int badge;
  
  @ApiModelProperty("消費項目繁中")
  private String name_tw;
  
  @ApiModelProperty("消費項目簡中")
  private String name_cn;
  
  @ApiModelProperty("消費項目日文")
  private String name_jp;
  
  @ApiModelProperty("消費項目英文")
  private String name_en;
  
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getMap() {
	return map;
}
public void setMap(String map) {
	this.map = map;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public int getBadge() {
	return badge;
}
public void setBadge(int badge) {
	this.badge = badge;
}
public String getName_tw() {
	return name_tw;
}
public void setName_tw(String name_tw) {
	this.name_tw = name_tw;
}
public String getName_cn() {
	return name_cn;
}
public void setName_cn(String name_cn) {
	this.name_cn = name_cn;
}
public String getName_jp() {
	return name_jp;
}
public void setName_jp(String name_jp) {
	this.name_jp = name_jp;
}
public String getName_en() {
	return name_en;
}
public void setName_en(String name_en) {
	this.name_en = name_en;
}
  
  
}
