package com.latam.project;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.latam.project.request.RequestPerson;
import com.latam.project.response.ResponsePerson;
import com.latam.project.service.ServiceInfoPeople;

@RestController("/")
public class InfoPeopleController {
	
	@Autowired
	ServiceInfoPeople servicePeople;

	@PostMapping
	(value = "/getInfoPerson", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ResponsePerson> getInfoPerson(@Valid @RequestBody RequestPerson person) {
		return new ResponseEntity<> (servicePeople.processData(person), HttpStatus.OK);
	}

}
