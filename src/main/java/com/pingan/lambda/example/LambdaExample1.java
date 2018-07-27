package com.pingan.lambda.example;

/**
 * Lambda示例1
 * Lambda表达式替换匿名类
 * 
 * @author ZHANGYONG415
 *
 */
public class LambdaExample1 {
	public static void main(String[] args) {
		new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("Before Java8, too much code for too little to do.");
			}
		}).start();
		
		new Thread(() -> System.out.println("In Java8, Lambda expression rocks!")).start();
	}
}
