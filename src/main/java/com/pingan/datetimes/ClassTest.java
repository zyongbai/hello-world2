package com.pingan.datetimes;

public class ClassTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Class clazz = Person.class;
		clazz.getConstructor();
//		clazz.getConstructor(com.pingan.datetimes.Person.class);
	}
}
