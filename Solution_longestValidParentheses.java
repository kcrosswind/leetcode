package com.bupt.kcrosswind.Leetcode;

import java.util.Stack;

public class Solution_longestValidParentheses {
	// 我擦嘞 理解错误了
	public static int longestValidParentheses(String s) {
		int reslut = 0;
		int tempreslut = 0;
		String reslutstring = new String();
		String temp;
		String str = "()";
		int i = 0;
		int length = s.length();
		while (i < length - 1) {
			temp = s.substring(i, i + 2);
			System.out.println(temp);
			if (temp.equals(str)) {
				tempreslut = 2;
				i = i + 2;
				while (i < length - 1) {
					temp = s.substring(i, i + 2);
					if (temp.equals(str)) {
						tempreslut = tempreslut + 2;
						i = i + 2;
					} else {
						break;
					}
				}
				if (tempreslut > reslut) {
					reslut = tempreslut;
				}
			} else {
				i++;
			}
		}
		return reslut;
	}

	public static int longestValidParentheses2(String s) {

		Stack<Character> temp = new Stack<Character>();// 字符的类型啊，要记！！！
		int reslut = 0;
		int tempreslut = 0;
		int i = 0;
		int length = s.length();
		System.out.println(length);
		while (i < length) {
			if (s.charAt(i) == '(') {
				temp.push(s.charAt(i));
				System.out.println("jin");
			} else if (s.charAt(i) == ')' && !temp.isEmpty()) {
				temp.pop();
				tempreslut = tempreslut + 2;
				if (reslut < tempreslut) {
					reslut = tempreslut;
					System.out.println("hehe");
				}
				System.out.println("chu");
			} else {
				tempreslut = 0;
			}
			i++;
		}
		return reslut;
	}

	//我的错误就是在一开始就没分清楚情况！！！！有几种形式！！！
	public static int longestValidParentheses3(String s) {
		int maxLen = 0, last = -1;
		Stack<Integer> lefts = new Stack<Integer>();
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '(') {
				lefts.push(i);
			} else {
				if (lefts.isEmpty()) {
					// no matching left
					last = i;
				} else {
					// find a matching pair
					lefts.pop();
					if (lefts.isEmpty()) {// 有一个完整的valid的group。计算该group的长度
						maxLen = Math.max(maxLen, i - last);
					} else {
						// 栈内还有‘(',一个最外层完整的group还没有匹配完成，
						// 但是通过查询下一个即将匹配还未匹配的"("的index来更新maxLen。
						maxLen = Math.max(maxLen, i - lefts.peek());
					}
				}
			}
		}
		return maxLen;
	}

	public static void main(String arg[]) {
		String hehe = "()()";
		System.out.println(longestValidParentheses3(hehe));
	}
}
