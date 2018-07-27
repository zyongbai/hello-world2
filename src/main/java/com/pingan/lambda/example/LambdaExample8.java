package com.pingan.lambda.example;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Lambda示例8
 * 对列表的每个元素应用函数
 * 
 * @author ZHANGYONG415
 *
 */
public class LambdaExample8 {
	public static void main(String[] args) {
		// 将字符串换成大写并用逗号链接起来
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
		
		String G7Countries = G7.stream().map(x -> x.toUpperCase())
							   .collect(Collectors.joining(","));
		
		System.out.println(G7Countries);
	}
}
