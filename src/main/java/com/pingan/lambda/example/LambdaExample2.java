package com.pingan.lambda.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Lambda示例2
 * 使用Lambda表达式进行事件处理
 * 
 * @author ZHANGYONG415
 *
 */
public class LambdaExample2 {
	public static void main(String[] args) {
		JButton show = new JButton("Show");
		show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Event handing without lambda expression is boring");
			}
		});
		
		show.addActionListener((e) -> {
			System.out.println("Light, Camera, Action!!Lambda expression Rocks");
		});
	}
}
