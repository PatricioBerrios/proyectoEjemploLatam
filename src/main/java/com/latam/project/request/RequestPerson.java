package com.latam.project.request;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestPerson {
	
	private String firstName;
	private String secondName;
	private String firstSurname;
	private String secondSurname;
	private LocalDate birthdayDate;
	
}
