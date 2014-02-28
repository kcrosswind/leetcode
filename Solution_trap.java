package com.bupt.kcrosswind.Leetcode;

public class Solution_trap {
	public static int trap(int[] A) {
		int length = A.length;
		int reslut = 0;
		System.out.println(A.toString());

		int i = 0;
		int j = length - 1;

		while (i < j) {
			System.out.println(A[i] + "++" + A[j]);

			if (A[i] == 0) {
				i++;
			} else if (A[j] == 0) {
				j--;
			} else {
				if (A[i] >= A[j]) {
					for (int k = j; k >= i; k--) {
						if (k == i) {
							return reslut;
						}
						if (A[k] < A[j]) {
							reslut = reslut + A[j] - A[k];

						} else {
							j = k;
							break;
						}
					}
				} else {
					for (int k = i; k <= j; k++) {
						if (k == j) {
							return reslut;
						}
						if (A[k] < A[i]) {
							reslut = reslut + A[i] - A[k];

						} else {
							i = k;
							break;
						}
					}
				}
			}
		}
		return reslut;
	}

	public static void main(String[] atgs) {
		int[] i = { 2, 0, 2 };
		System.out.println(trap(i));
	}
}
