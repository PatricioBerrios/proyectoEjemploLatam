package com.latam.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.latam.project.response.Poem;
import com.latam.project.util.Constants;
import com.latam.project.util.UtilInfoPerson;

@Service
public class ServicePoem {
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Autowired
    Environment env;
	
	public String getPoem() {
	     
		 ResponseEntity<List<Poem>> response = restTemplate().exchange(env.getProperty(Constants.endPointCongratsService), HttpMethod.GET, null, new ParameterizedTypeReference<List<Poem>>() {});
		 
		 if(response != null && response.getStatusCodeValue() == 200 && !response.getBody().isEmpty()) {
			 return UtilInfoPerson.obtainRandomPoem(response.getBody());
		 }else {
			 return env.getProperty(Constants.noAvailableService);
		 }
		 
	}

}
