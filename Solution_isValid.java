package com.bupt.kcrosswind.Leetcode;

import java.util.Stack;

public class Solution_isValid {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					char temp = stack.pop();
					if (s.charAt(i) == '(' && temp != ')') {
						return false;
					} else if (s.charAt(i) == '[' && temp != ']') {
						return false;
					} else if (s.charAt(i) == '{' && temp != '}') {
						return false;
					}
				}
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		char c = '{';
		char c1 = '}';
		System.out.println(c1 - c);
		System.out.println((char) (c + 1));
	}
}
