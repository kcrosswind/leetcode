package com.bupt.kcrosswind.Leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution_integertoRoman {
	public static class NumeralInvoke {
		int number;
		String numerbal;

		NumeralInvoke(int x, String s) {
			number = x;
			numerbal = s;
		}
	}

	public static List<Integer> getDigit(int x) {// 拆分成单独的数字
		List<Integer> arr = new ArrayList();

		int flag = 1;
		long dividend0;
		long dividend1;

		long temp = x;
		while (true) {
			dividend0 = (long) Math.pow(10, flag);
			dividend1 = (long) Math.pow(10, flag - 1);

			// arr.add((int)x % dividend0 / dividend1);
			// 这样写不对的！！结果存在一个空间这个空间无法转换格式，下面的就不一样，他有新的空间赋予给转换的变量！要看看java编程思想
			long digit = x % dividend0 / dividend1;
			arr.add((int) digit);
			flag++;

			if (x % dividend0 == x) {
				break;
			}
		}
		System.out.println(arr);
		return arr;
	}

	public static String intToRoman(int num) {// roman 基本可以确定由右向左

		String reslut = new String();

		List<Integer> digits = new ArrayList<Integer>();
		digits = getDigit(num);

		int size = digits.size();

		while (size > 0) {
			int temp = digits.get(size - 1);
			if (size == 4) {
				while (temp > 0) {
					reslut = reslut + "M";
					temp--;
				}
			} else if (size == 3) {

				if (temp < 4) {
					int temp2 = temp;
					while (temp2 > 0) {
						reslut = reslut + "C";
						temp2--;
					}

				} else if (temp == 4) {
					reslut = reslut + "CD";

				} else if (temp == 5) {
					reslut = reslut + "D";

				} else if (temp == 9) {
					reslut = reslut + "CM";

				} else {
					reslut = reslut + "D";
					int temp2 = temp;
					while (temp2 > 5) {
						reslut = reslut + "C";
						temp2--;
					}
				}

			} else if (size == 2) {

				if (temp < 4) {
					int temp2 = temp;
					while (temp2 > 0) {
						reslut = reslut + "X";
						temp2--;
					}

				} else if (temp == 4) {
					reslut = reslut + "XL";

				} else if (temp == 5) {
					reslut = reslut + "L";

				} else if (temp == 9) {
					reslut = reslut + "XC";

				} else {
					int temp2 = temp;
					reslut = reslut + "L";
					while (temp2 > 5) {
						reslut = reslut + "X";
						temp2--;
					}
				}
			} else if (size == 1) {

				if (temp < 4) {
					int temp2 = temp;
					while (temp2 > 0) {
						reslut = reslut + "I";
						temp2--;
					}

				} else if (temp == 4) {
					reslut = reslut + "IV";

				} else if (temp == 5) {
					reslut = reslut + "V";

				} else if (temp == 9) {
					reslut = reslut + "IX";

				} else {
					reslut = reslut + "V";
					int temp2 = temp;
					while (temp2 > 5) {
						reslut = reslut + "I";
						temp2--;
					}
				}
			}
			size--;
		}
		if (num % 10 > 0) {
			int remark = num / 1000;

		}
		return reslut;
	}

	private static List<NumeralInvoke> getNumeralBase() {

		List<NumeralInvoke> numeral = new ArrayList();

		numeral.add(new NumeralInvoke(1, "I"));
		numeral.add(new NumeralInvoke(5, "V"));
		numeral.add(new NumeralInvoke(10, "X"));
		numeral.add(new NumeralInvoke(50, "L"));
		numeral.add(new NumeralInvoke(100, "C"));
		numeral.add(new NumeralInvoke(500, "D"));
		numeral.add(new NumeralInvoke(1000, "M"));

		return numeral;
	}

	public static void main(String srgs[]) {
		System.out.println(intToRoman(2000));
	}
}
