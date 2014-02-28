package com.bupt.kcrosswind.Leetcode;

import java.util.HashSet;

public class Solution_minPathSum {
	public static int minPathSum(int[][] grid) {
		int high = grid.length;
		int wide = grid[0].length;

		if (high == 0) {
			return 0;
		} else {
			int[][] temp = new int[high][wide];
			int temphigh = 0;
			int tempwide = 0;
			while (tempwide < wide && temphigh < high) {
				if (tempwide < wide) {
					for (int i = tempwide; i < wide; i++) {
						if (temphigh - 1 >= 0 && i - 1 >= 0) {
							temp[temphigh][i] = Math.min(temp[temphigh][i - 1], temp[temphigh - 1][i]) + grid[temphigh][i];
						} else if (i - 1 >= 0) {
							temp[temphigh][i] = temp[temphigh][i - 1] + grid[temphigh][i];
						} else {
							temp[temphigh][i] = grid[temphigh][i];
						}
					}
					temphigh++;
				}
				if (temphigh < high) {
					for (int i = temphigh; i < high; i++) {
						if (tempwide - 1 >= 0 && i - 1 >= 0) {
							temp[i][tempwide] = Math.min(temp[i - 1][tempwide], temp[i][tempwide - 1]) + grid[i][tempwide];
						} else if (i - 1 >= 0) {
							temp[i][tempwide] = temp[i - 1][tempwide] + grid[i][tempwide];
						} else {
							temp[i][tempwide] = grid[i][tempwide];
						}
					}
					tempwide++;
				}
			}

			return temp[high - 1][wide - 1];
		}
	}

	public static void main(String[] args) {
//		int[][] grid = { { 1 } };
//		System.out.println(minPathSum(grid));
//		
//		HashSet<Boolean> hs = new HashSet<Boolean>();
//		hs.add(true);
//		hs.add(false);
//		if(hs.contains(false)){
//			System.out.println("1");
//		}
		String s = new String("123  456     789");
//		StringBuilder result = new StringBuilder("");
//		result.append(s);
//		result.toString();
//		s= s.trim();
		int[] temp = new int[8];
		for(String i : s.split("\\s{1,}")){
			String c = i.trim();
			System.out.println(c);
		}
		System.out.println();
//		System.out.println(result);
	}
}
