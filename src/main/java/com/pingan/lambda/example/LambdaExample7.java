package com.pingan.lambda.example;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Lambdaʾ��7
 * ͨ�����˴���һ��String�б�
 * 
 * @author ZHANGYONG415
 *
 */
public class LambdaExample7 {
	public static void main(String[] args) {
		List<String> strList = Arrays.asList("abc", "bcd", "defg", "jk", "lmhjj");
		List<String> filtered = strList.stream().filter(x -> x.length() > 2)
									   .collect(Collectors.toList());
		System.out.printf("Original List:%s, filtered list:%s %n", strList, filtered);
	}
}
