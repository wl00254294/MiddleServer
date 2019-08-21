package com.middle.main.bo;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description ="月點數資訊Entity")
public class MonthData {
	
	@ApiModelProperty("平台名稱")
	private String categorie;
	
	@ApiModelProperty("平台餘額資訊")
	private List<Data> values;
	
	
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public List<Data> getValues() {
		return values;
	}
	public void setValues(List<Data> values) {
		this.values = values;
	}
}
