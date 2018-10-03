package com.example.DHIS_DEMO;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.DHIS_DEMO.model.DataElements;
import com.example.DHIS_DEMO.model.DataSet;
import com.example.DHIS_DEMO.model.OrganisationUnits;
import com.example.DHIS_DEMO.repository.DataSetRepository;

@Component
@Configuration
public class BasicAuth {
	@Autowired
	DataSetRepository repository;
	@Value("${url.dataSet}")    
	String dataSetUrl;
	@Value("${url.orgUnits}")
	String dataorgUnits;
	@Value("${url.dataElements}")
	String dataElements;
	
	String plainCreds = "admin:district";
	byte[] plainCredsBytes = plainCreds.getBytes();
	byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
	String base64Creds = new String(base64CredsBytes);
	
	
	String orgUnitsUrl;
	RestTemplate restTemplate = new RestTemplate();
	
	
	@Scheduled(cron = " 0 59 22 * * * ")
	public DataSet fetchDatSet() {
		//String url = "https://play.dhis2.org/demo/api/dataValueSets.json?dataSet=pBOMPrpg1QX&period=201801&orgUnit=DiszpKrYNg8";
		if(dataSetUrl == null) {
			return null;
		}
		ResponseEntity<DataSet> response = restTemplate.exchange(dataSetUrl, HttpMethod.GET, getRequest(), DataSet.class);
		DataSet dataSet = response.getBody();
		
		FilePersistence persistence = new FilePersistence();
		persistence.saveToFile(dataSet, "/home/rezwann/sts/dhis_api_data.json");
		repository.save(dataSet);
		System.out.println("test fetchDatSet");
		return dataSet;
		}
	public DataElements fetchDataElements() {
		String url = "https://play.dhis2.org/demo/api/dataElements";
		ResponseEntity<DataElements> response = restTemplate.exchange(url, HttpMethod.GET, getRequest(), DataElements.class);
		DataElements dataElements = response.getBody();
		return dataElements;
	}
	
	public OrganisationUnits fetchOrganisationUnits() {
		String url = "https://play.dhis2.org/demo/api/organisationUnits";
		ResponseEntity<OrganisationUnits> response = restTemplate.exchange(url,  HttpMethod.GET, getRequest(), OrganisationUnits.class);
		OrganisationUnits  organisationUnits = response.getBody();
		return organisationUnits;
	}
	
	public HttpEntity<String> getRequest() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		HttpEntity<String> request = new HttpEntity<String>(headers);
		return request;
		}
}
