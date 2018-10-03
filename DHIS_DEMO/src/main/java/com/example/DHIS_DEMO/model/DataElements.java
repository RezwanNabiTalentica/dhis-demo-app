package com.example.DHIS_DEMO.model;

import java.io.Serializable;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "data_elements")
public class DataElements implements Serializable{
	@Id
	public ObjectId _id;
	List<DataElement> dataElements;

	public List<DataElement> getDataElements() {
		return dataElements;
	}
	public void setDataElements(List<DataElement> dataElements) {
		this.dataElements = dataElements;
	}
	}
