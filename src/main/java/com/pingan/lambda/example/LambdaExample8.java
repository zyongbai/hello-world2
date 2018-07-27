package com.pingan.lambda.example;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Lambdaʾ��8
 * ���б��ÿ��Ԫ��Ӧ�ú���
 * 
 * @author ZHANGYONG415
 *
 */
public class LambdaExample8 {
	public static void main(String[] args) {
		// ���ַ������ɴ�д���ö�����������
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
		
		String G7Countries = G7.stream().map(x -> x.toUpperCase())
							   .collect(Collectors.joining(","));
		
		System.out.println(G7Countries);
	}
}
