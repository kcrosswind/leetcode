package com.bupt.kcrosswind.Leetcode;

import java.util.Stack;

public class Solution_longestValidParentheses {
	// �Ҳ��� ��������
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

		Stack<Character> temp = new Stack<Character>();// �ַ������Ͱ���Ҫ�ǣ�����
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

	//�ҵĴ��������һ��ʼ��û�����������������м�����ʽ������
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
					if (lefts.isEmpty()) {// ��һ��������valid��group�������group�ĳ���
						maxLen = Math.max(maxLen, i - last);
					} else {
						// ջ�ڻ��С�(',һ�������������group��û��ƥ����ɣ�
						// ����ͨ����ѯ��һ������ƥ�仹δƥ���"("��index������maxLen��
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
