package com.latam.test.infoPeople;

import static org.mockito.Mockito.doReturn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.latam.project.service.ServicePoem;

@RunWith(MockitoJUnitRunner.class)
public class ServicePoemTest {
	
	@InjectMocks
	ServicePoem servicePoem;
	
	@Mock
    Environment env;
	
	@Mock
	RestTemplate restTemplate;
	
	private static final String endPointCongratsService = "ws.congrats.endpoint";
	private static final String endPointCongratsService_value = "https://www.poemist.com/api/v1/randompoems";

	@Test
	public void testGetPoemSuccessfull() {
		doReturn(endPointCongratsService_value).when(env).getProperty(endPointCongratsService); 
		servicePoem.getPoem();
		 
	}

}
