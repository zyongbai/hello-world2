package com.pingan.lambda.example;

import java.util.List;
import java.util.Arrays;

/**
 * Lambda示例3
 * 使用Lambda表达式对列表进行迭代
 * 
 * @author ZHANGYONG415
 *
 */
public class LambdaExample3 {
	public static void main(String[] args) {
		// Java 8之前
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		for (String feature : features) {
			System.out.println(feature);
		}
		
		// Java 8之后
		List<String> features2 = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		features2.forEach(n -> System.out.println(n));
		
		// 方法引用
		features2.forEach(System.out :: println);
	}
}
