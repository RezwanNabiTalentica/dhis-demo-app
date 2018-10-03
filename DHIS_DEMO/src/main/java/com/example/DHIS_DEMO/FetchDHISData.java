package com.example.DHIS_DEMO;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;




@EnableOAuth2Client
@Configuration
@Component
public class FetchDHISData {
	//private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);
	private static final String BASE_URL = "https://play.dhis2.org/dev";
	private static final String OAUTH_TOKEN_ENDPOINT = "/uaa/oauth/token";
	private static final String CLIENTID = "demoo";
	private static final String CLIENT_SECRET = "1e6db50c-0fee-11e5-98d0-3c15c2c6caf7";
	private static final String USERNAME = "admin";
	private static final String USER_SECRET = "district";
	private static final String DATA_ENDPOINT = "/api/dataElements.json";
	
	 protected OAuth2ProtectedResourceDetails resource() {

		ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
		resource.setAccessTokenUri(BASE_URL + OAUTH_TOKEN_ENDPOINT);
		resource.setClientId(CLIENTID);
		resource.setClientSecret(CLIENT_SECRET);
		resource.setGrantType("password");
		resource.setUsername(USERNAME);
		resource.setPassword(USER_SECRET);
	
		return resource;
	}
	//@Scheduled(fixedRate = 500)
	 public <T> T post(Object reqObject,Class<T> responseClass,String dataPoint) {

		AccessTokenRequest atr = new DefaultAccessTokenRequest();

		OAuth2RestTemplate oauthRestTemp = new OAuth2RestTemplate(resource(), new DefaultOAuth2ClientContext(atr));
		try {
			return oauthRestTemp.getForObject(new URI(BASE_URL + dataPoint),responseClass);
			
		} catch (RestClientException e) {
			System.out.println("DHIS data fetch failure" + e.getMessage());
			//LOGGER.error("error1", e);
		} catch (Exception e) {
			System.out.println("DHIS data fetch failure" + e.getMessage());
		//	LOGGER.error("error2", e);
		}
		return null;
	}
	//@Scheduled(fixedRate = 5000)
	public void test() {
		Object obj = post(null,  Object.class, "/api/dataElements.json");
		FilePersistence filePersistence = new FilePersistence();
		filePersistence.saveToFile(obj);
		System.out.println("test 123");
	}
}
