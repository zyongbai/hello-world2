package com.pingan.datetime;

import java.time.Month;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * LocalDate Example
 * 
 * @author ZHANGYONG415
 *
 */
public class LocalDateExample {
	public static void main(String[] args) {
		// Current Date
		LocalDate today = LocalDate.now();
		System.out.println("Current Date = " + today);
		
		// Creating LocalDate by providing input arguments
		LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
		System.out.println("Specific Date = " + firstDay_2014);
		
		// Current DateTime
		LocalDateTime todayDateTime = LocalDateTime.now();
		System.out.println(todayDateTime);
		
		// Current DateTime Format yyyy-MM-dd HH:mm:ss
		String dateTimeStr = todayDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println(dateTimeStr);
		
		// String Format DateTime Convert to DateTime
		LocalDateTime parseDateTime = LocalDateTime.parse("2018-01-01 16:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		System.out.println(parseDateTime);
	}
}
