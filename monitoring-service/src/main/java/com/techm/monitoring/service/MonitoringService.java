package com.techm.monitoring.service;

import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.techm.monitoring.domain.EmailMetaData;
import com.techm.monitoring.domain.HealthResult;
import com.techm.monitoring.domain.ServerDetails;

@Service
public class MonitoringService {
	
	@Autowired
	HealthResult healthResult;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Value("${dmit.notification.subject}")
	String subject;
	@Value("${dmit.notification.text}")
	String mailContents;
	@Value("${dmit.notification.emailAddresses}")
	String[] emailAddresses;
	
	public HealthResult pingURL(ServerDetails serverDetails) {
		
		// Otherwise an exception may be thrown on invalid SSL certificates.
		String url = serverDetails.getUrl().replaceFirst("^https", "http");
		int timeout = serverDetails.getTimeout();
		
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setConnectTimeout(timeout);
			connection.setReadTimeout(timeout);
			connection.setRequestMethod("HEAD");
			int responseCode = connection.getResponseCode();
			
			healthResult.setResponseCode(responseCode);
			healthResult.setUrl(url);
			healthResult.setHttpStatus(HttpStatus.valueOf(responseCode));
			healthResult.setCheckTime(new Date());
			
			return healthResult;
			//return (200 <= responseCode && responseCode <= 399);
		} catch (ConnectException | UnknownHostException e) {
			//exception.printStackTrace();
			EmailMetaData emailMetaData = new EmailMetaData(emailAddresses,subject,mailContents);
//			emailMetaData.setEmailAddresses(emailAddresses);
//			emailMetaData.setMailContents(mailContents);
//			emailMetaData.setSubject(subject);
			
			ResponseEntity<String> result = restTemplate.postForEntity("http://localhost:11002/email/sendWithAttachment", emailMetaData, String.class);
			System.out.println(result);
			
			return healthResult;
		} catch (IOException exception) {
			exception.printStackTrace();
			
			return healthResult;
		}

	}

	public boolean bulkCheck() {
		return false;
	}
}