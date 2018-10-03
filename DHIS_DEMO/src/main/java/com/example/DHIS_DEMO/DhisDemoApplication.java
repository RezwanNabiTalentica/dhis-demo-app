package com.example.DHIS_DEMO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DhisDemoApplication {

	static FetchDHISData fetchDataService = new FetchDHISData();
	static FilePersistence persistence = new FilePersistence();
	public static void main(String[] args) {
		SpringApplication.run(DhisDemoApplication.class, args);
		//fetchDataService.test();
		
		//demo app with basic authentication
		//FetchDataWithBasicAuthentication basicDataService = new FetchDataWithBasicAuthentication();
		//basicDataService.getRESTResponse("");
		
		BasicAuth basicAuth = new BasicAuth();
		basicAuth.fetchDatSet();
		//persistence.saveToFile(basicAuth.fetchData());
		//persistence.saveToFile(basicAuth.fetchDataElements(), "/home/rezwann/sts/dhis_api_dataElements.json");
		//persistence.saveToFile(basicAuth.fetchOrganisationUnits(), "/home/rezwann/sts/dhis_OrgUnits.json");
	}
}
