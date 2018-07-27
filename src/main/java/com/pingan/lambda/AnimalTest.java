package com.pingan.lambda;

public class AnimalTest {
	public static void main(String[] args) {
		Animal animal = () -> {
			System.out.println("I am running!");
		};
		
		animal.run();
	}
}
