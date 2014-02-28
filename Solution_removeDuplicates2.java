package com.bupt.kcrosswind.Leetcode;

import java.util.Arrays;

public class Solution_removeDuplicates2 {
	public static int removeDuplicates(int[] A) {
		if (A.length <= 2) {
			return A.length;
		}
		int[] temp = new int[A.length];
		int count = 1;
		int flag = 1;
		temp[0] = A[0];
		int cursor = 1;
		int i = 1;
		while (i < A.length) {

			if (A[i] != A[i - 1]) {
				flag = 1;
				temp[cursor++] = A[i];
				count++;
			} else {
				if (A[i] == A[i - 1]) {
					flag++;
				}
				if (A[i] == A[i - 1] && flag <= 2) {
					temp[cursor++] = A[i];
					count++;
				}
			}
			i++;
		}
		for (int j = 0; j < temp.length; j++) {
			A[j] = temp[j];
		}

		A = Arrays.copyOf(temp, count);
		// A = temp;
		return count;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 1, 2 };
		removeDuplicates(A);
		for (int i : A) {
			System.out.println(i);
		}
	}
}
