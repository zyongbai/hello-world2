package com.pingan.powertwo;

public class PowerTwo {
	/**
	 * 判断一个数是否是2的幂次方
	 * @param val
	 * @return
	 */
	public static boolean isPowerOfTwo(int val) {
		return (val & -val) == val;
	}
	
	public static void main(String[] args) {
		boolean flag1 = isPowerOfTwo(4);
		System.out.println("flag1:" + flag1);
		
		boolean flag2 = isPowerOfTwo(8);
		System.out.println("flag2:" + flag2);
	}
}
