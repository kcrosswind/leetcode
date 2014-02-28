package com.bupt.kcrosswind.Leetcode;

import java.util.Arrays;

public class Solution_divide {
	public static int divide(int dividend, int divisor) {
		long temp = dividend;
		long temp2 = divisor;
		temp = Math.abs(temp);
		temp2 = Math.abs(temp2);
		int result = 0;
		if (dividend == 0 || temp < temp2) {
			return 0;
		} else {
			while (temp >= temp2) {
				int i = 1;
				long temp3 = temp2;
				while (temp >= temp3 + temp3) {
					temp3 = temp3 + temp3;
					i = i + i;
					System.out.println("dfd");
				}
				result += i;
				temp = temp - temp3;

			}
			if((dividend < 0 && divisor >0)|| (dividend < 0 && divisor >0)) {
				return -result;
			}
			return result;
		}
	}

	public static void main(String[] args) {

//		long temp1 = -2147483648;
//		temp1 = Math.abs(temp1);
//		System.out.println(temp1);
		System.out.println(divide(-999511578, -2147483648));
		
        int[] temp ={1,2,3,4,5,6};
        int i = 1;
        int[] temp1 = Arrays.copyOf(temp ,2);
        StringBuilder b =new StringBuilder();
        b.to
        System.out.println(Arrays.toString(temp1));

	}

}
