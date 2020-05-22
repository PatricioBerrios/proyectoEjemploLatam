package com.latam.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.latam.project.request.RequestPerson;
import com.latam.project.response.ResponsePerson;
import com.latam.project.util.UtilInfoPerson;

@Service
public class ServiceInfoPeople {

	@Autowired
    Environment env;
	
	@Autowired
	ServicePoem servicePoem;

	public ResponsePerson processData(RequestPerson person) {
		
		ResponsePerson infoPerson = new ResponsePerson();
		infoPerson.setName(person.getFirstName());
		infoPerson.setSurName(person.getFirstSurname());
		infoPerson.setAge(UtilInfoPerson.getInfoAge(person.getBirthdayDate()));
		
		if(UtilInfoPerson.getDaysLeftToBirthday(person.getBirthdayDate()) != 0) {
			infoPerson.setMessageCongrats(String.valueOf(UtilInfoPerson.getDaysLeftToBirthday(person.getBirthdayDate())));
			infoPerson.setBirthday(false);
		}else {
			infoPerson.setMessageCongrats(servicePoem.getPoem());
			infoPerson.setBirthday(true);
		}
		
		return infoPerson;

	}

}
