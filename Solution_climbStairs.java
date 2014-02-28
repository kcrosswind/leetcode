package com.bupt.kcrosswind.Leetcode;

public class Solution_climbStairs {
	public static int climbStairs(int n) {
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		}
		int[] reslut = new int[n];
		reslut[0] = 1;
		reslut[1] = 2;
		for (int i = 2; i < n; i++) {
			reslut[i] = reslut[i - 1] + reslut[i - 2];
		}

		return reslut[n - 1];
	}

	public static int climbStairs2(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 0;
		} else {
			return 2 + climbStairs2(n - 1) + climbStairs2(n - 2);
		}
	}

	public static void main(String[] args) {
		// System.out.println(climbStairs(44));
		String s = "asdf";
		char[] c = s.toCharArray();// 字符串是有这个功能的
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}

		int[] A = {};
		int[] B = { 1 };
		if (A.length == 0) {
			A = B;
			for (int i = 0; i < B.length; i++) {

				System.out.println(A[i]);
			}
			System.out.println("A==null");
		} else {
			System.out.println("A!=null");
		}
	}
}
