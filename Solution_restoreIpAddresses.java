package com.bupt.kcrosswind.Leetcode;

import java.util.ArrayList;

public class Solution_restoreIpAddresses {

	public static ArrayList<String> restoreIpAddresses(String s) {

		ArrayList<String> result = new ArrayList<String>();
		if (s.length() < 4) {
			return result;
		}
		dfs(s, 0, new ArrayList<String>(), result);
		return result;
	}

	public static void dfs(String s, int cursor, ArrayList<String> iddr, ArrayList<String> result) {

		if (iddr.size() > 4 || cursor > s.length()) {
			return;
		}
		if (iddr.size() == 4 && cursor == s.length()) {

			String temp = new String();
			for (int i = 0; i < 3; i++) {
				temp = temp + iddr.get(i) + ".";
			}
			temp = temp + iddr.get(3);
			result.add(temp);
			return;
		}

		for (int i = 1; i <= 3; i++) {
			if (cursor + i <= s.length()) {
				String flag = s.substring(cursor, cursor + i);
				if (flag.length() > 1 && flag.charAt(0) == '0') {
					System.out.println("hehe");
					return;
				}else{
					int temp = Integer.valueOf(flag);
					if (temp <= 255) {
						iddr.add(flag);
						dfs(s, cursor + i, iddr, result);
						iddr.remove(iddr.size() - 1);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		String s = "010010";
		ArrayList<String> result = restoreIpAddresses(s);
		for (String i : result) {
			System.out.println(i);
		}
	}
}
