package com.example.DHIS_DEMO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.example.DHIS_DEMO.model.DataElements;
import com.example.DHIS_DEMO.model.DataSet;
import com.example.DHIS_DEMO.model.OrganisationUnits;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilePersistence {
	
	public void saveToFile(Object obj) {
		try {
		FileOutputStream fos = new FileOutputStream("/home/rezwann/sts/dhis_api_data.json");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		if(obj instanceof DataElements) {
			obj = (DataElements)obj;
		}
		oos.writeObject(obj);
		System.out.println("Done object");
		oos.close();
		fos.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	public void saveToFile(Object obj, String fileName) {
		try {
			if(obj instanceof DataSet) {
				obj = (DataSet) obj;
			}
		if(obj instanceof DataElements) {
			obj = (DataElements)obj;
		}else if(obj instanceof OrganisationUnits) {
			obj = (OrganisationUnits)obj;
		}
		File file = new File(fileName);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(file, obj);
		System.out.println("File created ");
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	public void saveToFile(DataSet obj) {
		try {
			File file = new File("/home/rezwann/sts/dhis_api_data.json");
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(file, obj);
			System.out.println("File created ");
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
