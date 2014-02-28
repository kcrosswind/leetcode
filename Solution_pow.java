package com.bupt.kcrosswind.Leetcode;

public class Solution_pow {
	public static double pow(double x, int n) {
		if (x == 1) {
			return 1;
		}
		if (n >= 0) {
			return positivePow(x, n);
		} else {
			return 1 / positivePow(x, -n);
		}
	}

	public static double positivePow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		if (n % 2 == 0) {
			double temp = positivePow(x, n / 2);
			return temp * temp;
		} else {
			double temp = positivePow(x, n / 2);
			return temp * temp * x;
		}
	}

	public static void main(String[] args) {
		System.out.println(pow(0.00001, 2147483647));
	}
}
