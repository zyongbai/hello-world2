package com.pingan.datetimes;

import java.util.Calendar;

public class ExecuteDateTime {
	public static void main(String[] args) {
		Calendar date1 = Calendar.getInstance();
		date1.set(2017, 11, 04, 0, 0, 0);
		System.out.println("date1:" + date1.getTime());
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2017, 10, 04, 0, 0, 0);
		System.out.println("date2:" + date2.getTime());
		
		long num = date1.getTimeInMillis() - date2.getTimeInMillis();
		
		double day = (num * 1.0) / (60 * 60 * 24 * 1000);
		System.out.println(day);
	}
}
