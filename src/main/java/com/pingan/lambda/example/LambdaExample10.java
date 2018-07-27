package com.pingan.lambda.example;

import java.util.List;
import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * Lambda示例10
 * 计算集合元素的最大值、最小值、总和以及平均值
 * 
 * @author ZHANGYONG415
 *
 */
public class LambdaExample10 {
	public static void main(String[] args) {
		// 获取数字的个数、最小值、最大值、总和以及平均值
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics stats = primes.stream().mapToInt(x -> x)
										   .summaryStatistics();
		System.out.println("Highest prime number in List:" + stats.getMax());
		System.out.println("Lowest prime number in List:" + stats.getMin());
		System.out.println("Sum of all prime numbers:" + stats.getSum());
		System.out.println("Average of all prime numbers:" + stats.getAverage());
	}
}
