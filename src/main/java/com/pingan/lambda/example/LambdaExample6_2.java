package com.pingan.lambda.example;

import java.util.List;
import java.util.Arrays;

/**
 * Lambdaʾ��6_2
 * ʹ��lambda���ʽ��Map��Reduceʾ��
 * 
 * @author ZHANGYONG415
 *
 */
public class LambdaExample6_2 {
	public static void main(String[] args) {
		// �ɷ���
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double total = 0;
		for (Integer cost : costBeforeTax) {
			double price = cost + 0.12 * cost;
			total = total + price;
		}
		System.out.println("Total:" + total);
		
		// �·���
		double bill = costBeforeTax.stream().map((cost) -> cost + 0.12 * cost)
								   .reduce((sum, cost) -> sum + cost)
								   .get();
		System.out.println("Total:" + bill);
	}
}
