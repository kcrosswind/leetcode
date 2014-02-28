package com.bupt.kcrosswind.Leetcode;

public class Solution_searchInsert {
	public int searchInsert(int[] A, int target) {
		int length = A.length;
		int i = 0;
		while (i < length) {
			if (A[i] >= target) {
				break;
			}
			i++;
		}
		return i;
	}

}
