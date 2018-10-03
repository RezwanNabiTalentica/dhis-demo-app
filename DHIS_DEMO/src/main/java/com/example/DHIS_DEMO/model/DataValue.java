package com.example.DHIS_DEMO.model;

import java.io.Serializable;

public class DataValue implements Serializable{
	String dataElement;
	String period;
	String orgUnit;
	String value;
	public String getDataElement() {
		return dataElement;
	}
	public void setDataElement(String dataElement) {
		this.dataElement = dataElement;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getOrgUnit() {
		return orgUnit;
	}
	public void setOrgUnit(String orgUnit) {
		this.orgUnit = orgUnit;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	
}
