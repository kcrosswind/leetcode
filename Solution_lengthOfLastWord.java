package com.bupt.kcrosswind.Leetcode;

public class Solution_lengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		System.out.println(s.length());
		s.trim();
		System.out.println(s.trim().length());
		if (s.trim().length() == 0) {
			return 0;
		}
		String[] temp = s.split(" ");
		if (temp == null) {
			return 0;
		}
		return temp[temp.length - 1].length();
	}
	//在在//注意范围 不要老是由于 想清楚范围 最后一个明显不用判断
	public static void main(String[] args) {
		lengthOfLastWord(" ");
	}
}
