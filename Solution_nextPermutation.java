package com.bupt.kcrosswind.Leetcode;

import com.bupt.kcrosswind.Leetcode.Solution_addTwoNumbers.ListNode;

public class Solution_nextPermutation {
	public static void nextPermutation(int[] num) {
		int flag = 0;
		int temp;
		int length = num.length;
		int i = length - 1;

		while (i > 0) {
			if (num[i] > num[i - 1]) {
				int j = length - 1;
				while (j > 0) {
					if (num[i - 1] < num[j]) {
						temp = num[i - 1];
						num[i - 1] = num[j];
						num[j] = temp;
						flag = 1;
						nixu(num, i, length - 1);
					}
					j--;
				}
			}
			i--;
		}
		if (flag == 0) {
			nixu(num, 0, length - 1);
		}
	}

	public static void nixu(int[] num, int i, int j) {
		int middle = i + (j - i) / 2;
		int temp;

		while (i <= middle) {
			temp = num[i];
			num[i] = num[j];
			num[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String args[]) {

		int[] s = { 1, 2, 3 };
		nixu(s, 0, 2);
		for (int i = 0; i < 3; i++) {
			System.out.println(s[i]);
		}
	}
}
