package com.pingan.lambda.example;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Lambda示例9
 * 复制不同的值，创建一个子列表
 * 
 * @author ZHANGYONG415
 *
 */
public class LambdaExample9 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		
		List<Integer> distinct = numbers.stream().map(i -> i * i)
							   .distinct().collect(Collectors.toList());
		
		System.out.printf("Original List:%s, Square Without duplicates:%s %n", numbers, distinct);
	}
}
