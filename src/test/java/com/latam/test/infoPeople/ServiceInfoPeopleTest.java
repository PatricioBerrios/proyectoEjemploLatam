package com.latam.test.infoPeople;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;

import com.latam.project.request.RequestPerson;
import com.latam.project.service.ServiceInfoPeople;
import com.latam.project.service.ServicePoem;
@RunWith(MockitoJUnitRunner.class)
public class ServiceInfoPeopleTest {
	
	@InjectMocks
	ServiceInfoPeople infoPeopleService = new ServiceInfoPeople();
	
	@Mock
	ServicePoem servicePoem;
	
	@Mock
    Environment env;

	@Test
	public void testProcessDataBirthdayNoTodayBeginningYear() {
		
		RequestPerson request = loadData();
		request.setBirthdayDate(LocalDate.of(1990, 01, 01));
		infoPeopleService.processData(request);
	}
	
	@Test
	public void testProcessDataBirthdayNoTodayEndYear() {
		
		RequestPerson request = loadData();
		request.setBirthdayDate(LocalDate.of(1990, 12, 31));
		infoPeopleService.processData(request);
	}
	
	@Test
	public void testProcessDataBirthdayToday() {
		
		RequestPerson request = loadData();
		request.setBirthdayDate(LocalDate.now());
		infoPeopleService.processData(request);
	}

	private RequestPerson loadData() {
		
		RequestPerson request = new RequestPerson();
		request.setFirstName("Patricio");
		request.setSecondName("Salvador");
		request.setFirstSurname("Berrios");
		request.setSecondSurname("Maureira");
		return request;
		
	}

}
