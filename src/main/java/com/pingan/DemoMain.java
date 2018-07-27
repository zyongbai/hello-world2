package com.pingan;

import java.util.HashMap;
import java.util.Map;

public class DemoMain {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("a", "aa");
		map.put("a", "aa");
		System.out.println(map.toString());
	}
}
