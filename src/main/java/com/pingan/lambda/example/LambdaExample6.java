package com.pingan.lambda.example;

import java.util.List;
import java.util.Arrays;

/**
 * Lambdaʾ��6
 * ʹ��lambda���ʽ��Map��Reduceʾ��
 * 
 * @author ZHANGYONG415
 *
 */
public class LambdaExample6 {
	public static void main(String[] args) {
		// ��ʹ��lambda���ʽΪÿ����������12%��˰
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		for (Integer cost : costBeforeTax) {
			double price = cost + 0.12 * cost;
			System.out.println(price);
		}
		
		// ʹ��lambda���ʽ
		costBeforeTax.stream().map((cost) -> cost + 0.12 * cost)
							  .forEach(System.out :: println);
	}
}
