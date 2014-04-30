package com.bupt.kcrosswind.Leetcode;

/*Edit Distance ：
 Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character
 */
public class Solution_minDistance {
	public int minDistance(String word1, String word2) {
		// 入口条件判断
		if (word1.length() == 0 || word2.length() == 0) {
			if (word1.length() == 0) {
				return word2.length();
			} else {
				return word1.length();
			}
		}
		// 初始化memoization
		// 初始话的规则一个子串的单个字符同递增的第二个子串全比较
		int[][] temp = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i <= word1.length(); i++) {
			temp[i][0] = i;
		}
		for (int j = 0; j <= word2.length(); j++) {
			temp[0][j] = j;
		}
		// 递归填充memoization
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				int temp1 = Math.min(temp[i - 1][j] + 1, temp[i][j - 1] + 1);
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					temp[i][j] = Math.min(temp[i - 1][j - 1], temp1);
				} else {
					temp[i][j] = Math.min(temp[i - 1][j - 1] + 1, temp1);
				}
			}
		}
		return temp[word1.length()][word2.length()];
	}
}
