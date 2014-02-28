package com.bupt.kcrosswind.Leetcode;

public class Solution_longestPalindrome {
	public static String longestPalindrome(String s) {
		String reslut = new String();

		int length = s.length();
		if (length <= 1) {
			return s;
		}
//		int[][] temp = new int[length][length];
		boolean[][] temp = new boolean[length][length];
		// ³õÊ¼»¯
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i >= j) {
					temp[i][j] = true;
				} else {
					temp[i][j] = false;
				}
			}
		}

		int i;
		int j = 1;
		int maxlen = 0;
		int ri=0;
		int rj=0;
		while (j < length) {
			i = j - 1;

			while (i >= 0) {
				if (s.charAt(i) != s.charAt(j)) {
				    temp[i][j] = false;

				} else {
					temp[i][j] = temp[i + 1][j - 1];
					if (temp[i][j] == true && (j - i + 1) > maxlen) {
					    ri=i;
					    rj=j;
					    maxlen = j - i+ 1;
				    }
				}

				i--;
			}
			j++;
		}

//		for (int m = 0; m < length; m++) {
//			for (int n = 0; n < length; n++) {
//				System.out.println(temp[m][n]);
//			}
//		}
		return s.substring(ri, rj+1);
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}
}
