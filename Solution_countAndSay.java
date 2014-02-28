package com.bupt.kcrosswind.Leetcode;

import java.util.Arrays;

public class Solution_countAndSay {
	public static String countAndSay(int n) {
		int[] temp = new int[10];
		int i = 1;
		temp[0] = (int) (n % Math.pow(10, 1));
		while ((n / Math.pow(10, i + 1)) >= 1) {//long型的 不准确！！！
			System.out.println(n / Math.pow(10, i + 1));
			temp[i] = (int) (n % Math.pow(10, i + 1) / Math.pow(10, i));
			i++;
		}
		int[] temp1 = Arrays.copyOf(temp, i );

		int[] status = new int[10];
		for (int j = 0; j < temp1.length; j++) {
			status[temp1[j]]++;
		}
		StringBuilder result = new StringBuilder();
		for (int j = 9; j >= 0; j--) {
			if (status[j] != 0) {
				result.append(status[j]);
				result.append(j);
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(countAndSay(1));
	}
}
