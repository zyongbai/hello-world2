package com.pingan.lambda.example;

import java.util.List;
import java.util.Arrays;

/**
 * Lambdaʾ��3
 * ʹ��Lambda���ʽ���б���е���
 * 
 * @author ZHANGYONG415
 *
 */
public class LambdaExample3 {
	public static void main(String[] args) {
		// Java 8֮ǰ
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		for (String feature : features) {
			System.out.println(feature);
		}
		
		// Java 8֮��
		List<String> features2 = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		features2.forEach(n -> System.out.println(n));
		
		// ��������
		features2.forEach(System.out :: println);
	}
}
