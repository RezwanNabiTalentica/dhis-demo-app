package com.example.DHIS_DEMO.model;

import java.io.Serializable;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Document(collection = "dhis.dataSet")
public class DataSet implements Serializable{
	
	@Id
	private ObjectId _id;
	
	String dataSet;
	String completeDate;
	String period;
	String orgUnit;
	List<DataValue> dataValues;
	
	
	
	public ObjectId get_id() {
		return _id;
	}



	public void set_id(ObjectId _id) {
		this._id = _id;
	}



	public String getDataSet() {
		return dataSet;
	}



	public void setDataSet(String dataSet) {
		this.dataSet = dataSet;
	}



	public String getCompleteDate() {
		return completeDate;
	}



	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
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



	public List<DataValue> getDataValues() {
		return dataValues;
	}



	public void setDataValues(List<DataValue> dataValues) {
		this.dataValues = dataValues;
	}

}
