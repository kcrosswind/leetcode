package com.bupt.kcrosswind.Leetcode;

public class Solution_evalPRN {

	public static void evalPRN(String[] tokens) {

		int flag = 0;
		int reslut = 0;
		int size = tokens.length;
		while (flag != tokens.length) {
			while (tokens[flag] == "+" || tokens[flag] == "-" || tokens[flag] == "*" || tokens[flag] == "/") {

				int i = flag - 1;// �������flagλ��
				String j = null;// ����1
				String k = null;// ����2

				while (i >= 0) {
					if (j != null && k != null) {
						break;
					}
					if (tokens[i] != null) {
						if (j == null) {
							j = tokens[i];
							tokens[i] = null;
						}
						else if (k == null) {
							k = tokens[i];
							tokens[i] = null;
						}
					}
					i--;
				}
				if (j != null && k != null) {
					int j2 = Integer.parseInt(j);
					int k2 = Integer.parseInt(k);
					if (tokens[flag] == "+") {
						tokens[flag] = Integer.toString(j2 + k2);
					}
					if (tokens[flag] == "*") {
						tokens[flag] = Integer.toString(j2 * k2);
					}
					if (tokens[flag] == "-") {
						tokens[flag] = Integer.toString(k2 - j2);
					}
					if (tokens[flag] == "/") {
						tokens[flag] = Integer.toString(k2 / j2);
					}
				}
			}
			flag++;
		}
		reslut = Integer.parseInt(tokens[size - 1]);
		System.out.println(reslut);
		// return reslut;

	}

	public static void main(String args[]) {
		String[] tokens = { "2", "1", "+", "4", "*" };
		String[] to = { "4", "13", "5", "/", "+" };
		String[] to1 = { "3", "-4", "+" };

		evalPRN(tokens);
		evalPRN(to);
		evalPRN(to1);
	}
}
