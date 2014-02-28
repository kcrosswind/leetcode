package com.bupt.kcrosswind.Leetcode;

public class Solution_atoi {

	public static int atoi(String str) {
		int length = str.length();
		if (length == 0) {
			return 0;
		}
		int i = 0;
		int[] temp = new int[length];
		int j = 0;
		int negative = 1;
		int flag = 0;
		long reslut = 0;
		int tempfalg = 0;
		while (i < length) {
			if (str.charAt(i) == '-') {

				if (tempfalg == 1) {
					return 0;
				}
				negative = -1;
				tempfalg = 1;

			} else if (str.charAt(i) == '+') {
				if (tempfalg == 1) {
					return 0;
				}
				tempfalg = 1;

			}else if(str.charAt(i)>='0'&&str.charAt(i)<='9'){//ºÜÖØÒª°¡
				temp[j]=str.charAt(i)-'0';
				j++;
				tempfalg = 1;
			}
//			else if (str.charAt(i) == '0') {
//				temp[j] = 0;
//				j++;
//				tempfalg = 1;
//			} else if (str.charAt(i) == '1') {
//				temp[j] = 1;
//				j++;
//				tempfalg = 1;
//			} else if (str.charAt(i) == '2') {
//				temp[j] = 2;
//				j++;
//				tempfalg = 1;
//			} else if (str.charAt(i) == '3') {
//				temp[j] = 3;
//				j++;
//				tempfalg = 1;
//			} else if (str.charAt(i) == '4') {
//				temp[j] = 4;
//				j++;
//				tempfalg = 1;
//			} else if (str.charAt(i) == '5') {
//				temp[j] = 5;
//				j++;
//				tempfalg = 1;
//			} else if (str.charAt(i) == '6') {
//				temp[j] = 6;
//				j++;
//				tempfalg = 1;
//			} else if (str.charAt(i) == '7') {
//				temp[j] = 7;
//				j++;
//				tempfalg = 1;
//			} else if (str.charAt(i) == '8') {
//				temp[j] = 8;
//				j++;
//				tempfalg = 1;
//			} else if (str.charAt(i) == '9') {
//				temp[j] = 9;
//				j++;
//				tempfalg = 1;
//			} 
		else {
				if (str.charAt(i) != ' ') {
					break;
				}
				if (tempfalg == 1) {
					break;
				}
			}
			i++;
		}

		for (int k = j - 1; k >= 0; k--) {
			reslut = reslut + temp[k] * (long) Math.pow(10, flag);
			flag++;
		}
		if (reslut * negative > Integer.MAX_VALUE) {// yikaishi yiwei2147483647
			return Integer.MAX_VALUE;
		}
		if (reslut * negative < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return (int) reslut * negative;
	}

	public static void main(String[] args) {
		String s = "345";
		System.out.println(atoi(s));
	}
}
