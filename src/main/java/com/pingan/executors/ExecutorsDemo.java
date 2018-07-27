package com.pingan.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ExecutorsDemo {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
	}
}
