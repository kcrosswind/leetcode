package com.bupt.kcrosswind.Leetcode;

public class Solution_firstMissingPositive {
	public static int firstMissingPositive(int[] A) {
		int length = A.length;
		if (length == 0) {
			return 1;
		}
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (A[i] > A[j]) {
					int temp;
					temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
			}
			if (A[i] > 1) {
				if (i == 0) {
					return 1;
				}
				if (A[i] > A[i - 1] + 1) {
					if (A[i - 1] <= 0) {
						return 1;
					} else {
						return A[i - 1] + 1;
					}
				}
			}
		}
		for (int i = 0; i < length; i++) {
			System.out.println("paixu" + A[i]);
		}

		if (A[length - 1] == 1) {
			return 2;
		} else {
			System.out.println(A[length - 1]);
			return A[length - 1] + 1;
		}
	}

	public static void main(String[] args) {
		int[] s = { 1, 2, 2, 1, 3, 1, 0, 4, 0 };
		System.out.println(firstMissingPositive(s));
	}
}
