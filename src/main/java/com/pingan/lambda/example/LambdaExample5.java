package com.pingan.lambda.example;

import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Lambda示例5
 * Predicate联合使用
 * 
 * @author ZHANGYONG415
 *
 */
public class LambdaExample5 {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Java", "Scala", "C++", "Php");
		
		Predicate<String> startWithJ = (String n) -> n.startsWith("J");
		Predicate<String> fourLetterLong = (String n) -> n.length() == 4;
		
		names.stream().filter(startWithJ.and(fourLetterLong))
					  .forEach((n) -> System.out.print("names, which starts with 'J' and four letter long is:" + n));
	}
}
