package com.bupt.kcrosswind.Leetcode;

public class Solution_isPalindrome2 {
	public static boolean isPalindrome(String s) {
		char[] reslut = new char[s.length()];
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) <= 'z' && s.charAt(i) >= 'a') {
				reslut[j] = s.charAt(i);
				j++;
			} else if (s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') {
				reslut[j] = (char) (s.charAt(i) + 32);
				j++;
			} else if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
				reslut[j] = s.charAt(i);
				j++;
			}
		}
		for (int i = 0; i < j; i++) {
			if (reslut[i] != reslut[j - 1]) {
				return false;
			}
			j--;
		}
		return true;
	}

	public boolean isPalindrome2(String s) {
		for (int i = 0, j = s.length() - 1; i < j;) {
			if (alphanumeric(s.charAt(i)) == ' ') {
				i++;
			} else if (alphanumeric(s.charAt(j)) == ' ') {
				j++;
			} else {
				if (alphanumeric(s.charAt(i)) != alphanumeric(s.charAt(j))) {
					return false;
				}
				i++;
				j++;
			}
		}
		return true;
	}

	public char alphanumeric(char c) {
		if (c <= 'z' && c >= 'a') {
			return c;
		} else if (c <= 'Z' && c >= 'A') {
			return (char) (c + 32);
		} else if (c <= '9' && c >= '0') {
			return c;
		}
		return ' ';
	}

	public static void main(String[] args) {
		Character c = 'a';
		Character c1 = 'A';
		if (c > c1) {
			System.out.println(c - c1);
		}
		String s = "Bab";
		System.out.println(isPalindrome(s));
	}
}
