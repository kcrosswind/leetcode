package com.bupt.kcrosswind.Leetcode;

public class Solution_removeDuplicates {
	public static int removeDuplicates(int[] A) {
		int i = 1;
		int reslut = 0;
		int length = A.length;

		while (i < length) {
			if (A[i] == A[i - reslut - 1]) {
				reslut = reslut + 1;

			} else {
				A[i - reslut] = A[i];

			}
			i++;
		}

		return length - reslut;

	}

	public static void main(String[] args) {
		int[] A = { 1, 1 };
		
		String ss="ssssss";
		
		System.out.println(ss.substring(1, 2));

		System.out.println(removeDuplicates(A));
	}
}
