package com.latam.project.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import com.latam.project.response.Poem;

public final class UtilInfoPerson {

	public static String getInfoAge(LocalDate birthdayDate) {

		return String.valueOf(Period.between(birthdayDate, LocalDate.now()).getYears());
		
	}
	
	public static long getDaysLeftToBirthday(LocalDate birthdayDate) {

		birthdayDate = LocalDate.of(LocalDate.now().getYear(), birthdayDate.getMonth(), birthdayDate.getDayOfMonth());
		
		if(LocalDate.now().until(birthdayDate, ChronoUnit.DAYS) > 0) {
			return Math.abs(LocalDate.of(LocalDate.now().getYear()+1, LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth()).until(birthdayDate, ChronoUnit.DAYS));
		}else {
			return Math.abs(LocalDate.now().until(birthdayDate, ChronoUnit.DAYS));
		}
		
	}
	
	public static String obtainRandomPoem(List<Poem> listPoems) {

		return listPoems.stream().
				skip(new Random().nextInt(listPoems.size()-1)).
				findFirst().get().getContent();
	
}

}
