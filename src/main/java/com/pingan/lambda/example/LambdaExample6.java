package com.pingan.lambda.example;

import java.util.List;
import java.util.Arrays;

/**
 * Lambda示例6
 * 使用lambda表达式的Map和Reduce示例
 * 
 * @author ZHANGYONG415
 *
 */
public class LambdaExample6 {
	public static void main(String[] args) {
		// 不使用lambda表达式为每个订单加上12%的税
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		for (Integer cost : costBeforeTax) {
			double price = cost + 0.12 * cost;
			System.out.println(price);
		}
		
		// 使用lambda表达式
		costBeforeTax.stream().map((cost) -> cost + 0.12 * cost)
							  .forEach(System.out :: println);
	}
}
