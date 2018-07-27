package com.pingan.lambda;

import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.BiConsumer;

public class LambdaTest {
	Runnable thread = () -> System.out.println("lambda");
	BiConsumer<String, String> consumer = (key, value) -> {
		System.out.println(key + ":" + value);
	};
	
	public void test() {
		thread.run();
		
		String text = "test";
//		text = "test change";
		
		List<Integer> list = Arrays.asList(1, 2);
		list.forEach(value -> {
			System.out.println(text + value);
		});
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("test", "test");
		map.forEach(consumer);
	}
	
	public static void main(String[] args) {
		LambdaTest lambdaTest = new LambdaTest();
		lambdaTest.test();
	}
}
