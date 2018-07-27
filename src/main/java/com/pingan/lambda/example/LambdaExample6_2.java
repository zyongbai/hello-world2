package com.pingan.lambda.example;

import java.util.List;
import java.util.Arrays;

/**
 * Lambda示例6_2
 * 使用lambda表达式的Map和Reduce示例
 * 
 * @author ZHANGYONG415
 *
 */
public class LambdaExample6_2 {
	public static void main(String[] args) {
		// 旧方法
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double total = 0;
		for (Integer cost : costBeforeTax) {
			double price = cost + 0.12 * cost;
			total = total + price;
		}
		System.out.println("Total:" + total);
		
		// 新方法
		double bill = costBeforeTax.stream().map((cost) -> cost + 0.12 * cost)
								   .reduce((sum, cost) -> sum + cost)
								   .get();
		System.out.println("Total:" + bill);
	}
}
