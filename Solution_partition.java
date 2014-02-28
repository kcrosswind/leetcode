package com.bupt.kcrosswind.Leetcode;

import java.util.ArrayList;

public class Solution_partition {
	public ArrayList<ArrayList<String>> partition1(String s) {//动态规划
		int[][] marker = new int[s.length()][s.length()];
		for (int i = 0; i < marker.length; i++) {
			for (int j = i; j >= 0; j--) {
				marker[i][j] = 1;
			}
		}
		for (int j = 1; j < marker.length; j++) {
			for (int i = j - 1; i >= 0; i--) {
				if (s.charAt(i) == s.charAt(j)) {
					marker[i][j] = marker[i + 1][j - 1];
				}
			}
		}
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < marker.length; i++) {
			for (int j = i; j < marker.length; j++) {
				if (marker[i][j] == 1) {

				}
			}
		}
		ArrayList<ArrayList<String>> reslut = new ArrayList<ArrayList<String>>();
		return reslut;
	}

	public ArrayList<ArrayList<String>> partition(String s) {//dfs

		if (s.length() == 0) {
			return null;
		}
		ArrayList<ArrayList<String>> reslut = new ArrayList<ArrayList<String>>();
		ArrayList<String> iterm = new ArrayList<String>();
		dfs(reslut, iterm, s);

		return reslut;
	}

	public void dfs(ArrayList<ArrayList<String>> reslut, ArrayList<String> iterm, String s) {
		if (s.length() == 0) {
			reslut.add(new ArrayList<String>(iterm));
		}
		int len = s.length();
		for (int i = 1; i <= len; i++) {
			String tempStr = s.substring(0, i);//太牛逼了 一定要记住
			if (isPal(tempStr)) {
				iterm.add(tempStr);
				dfs(reslut, iterm, s.substring(i));
				iterm.remove(iterm.size() - 1);
			}
		}
	}

	public boolean isPal(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public void subString(ArrayList<String> temp, String s, int flag) {
		temp.add(s.substring(flag));
	}
}
