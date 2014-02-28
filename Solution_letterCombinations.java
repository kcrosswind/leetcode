package com.bupt.kcrosswind.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution_letterCombinations {
	public static ArrayList<String> letterCombinations(String digits) {

		ArrayList<String> reslut = new ArrayList<String>();

		if (digits.length() == 0) {
			reslut.add(digits);
			return reslut;
		}

		String temp;
		HashMap<Character, String[]> phone = new HashMap<Character, String[]>();
		String[] temp2 = { "a", "b", "c" };
		String[] temp3 = { "d", "e", "f" };
		String[] temp4 = { "g", "h", "i" };
		String[] temp5 = { "j", "k", "l" };
		String[] temp6 = { "m", "n", "o" };
		String[] temp7 = { "p", "q", "r", "s" };
		String[] temp8 = { "t", "u", "v" };
		String[] temp9 = { "w", "x", "y", "z" };
		phone.put('2', temp2);
		phone.put('3', temp3);
		phone.put('4', temp4);
		phone.put('5', temp5);
		phone.put('6', temp6);
		phone.put('7', temp7);
		phone.put('8', temp8);
		phone.put('9', temp9);
		for (int i = 0; i < digits.length(); i++) {
			if (i==0) {
				String[] s = phone.get(digits.charAt(i));
				for (int j = 0; j < s.length; j++) {
					reslut.add(s[j]);
				}
			} else {
				int length = reslut.size();
				String[] s = phone.get(digits.charAt(i));
				for (int j = 0; j < length; j++) {
					temp = reslut.remove(j);
					for (int k = 0; k < s.length; k++) {
						reslut.add(temp + s[k]);
					}
				}
			}

		}

		return reslut;
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("2"));
	}
}
