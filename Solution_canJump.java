package com.bupt.kcrosswind.Leetcode;

import java.util.Stack;

public class Solution_canJump {
	public boolean canJump(int[] A) {
		int length = A.length;

		if (length <= 1) {
			return true;
		}
		Stack<Integer> s = new Stack<Integer>();

		int i = 0;
		s.add(A[i]);
		int j = i + A[i];
		while (j < length - 1) {
			if (A[j] == 0) {
				int temp = s.pop();
				if(temp==1){
					
				}

			}
			if (s.empty()) {
				return false;
			}
		}
		return true;
	}
}
