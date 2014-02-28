package com.bupt.kcrosswind.Leetcode;

import java.util.HashMap;

public class Solution_convertzigzag {

	public static String convert(String s, int nRows) {

		Character[][] zigzag = new Character[nRows][s.length()];
		String reslut = new String();
		int length = 0;
		int slength = s.length();
		int j;

		if (slength <= 1 || nRows == 1) {
			return s;
		}

		for (j = 0; length < slength; j++) {
			if (j % (nRows - 1) == 0) {
				for (int i = 0; i < nRows && length < slength; i++) {
					zigzag[i][j] = s.charAt(length);
					length++;
				}
			} else {
				System.out.println(s.charAt(length));
				zigzag[nRows - j % (nRows - 1) - 1][j] = s.charAt(length);
				length++;

			}

		}

		for (int i = 0; i < nRows; i++) {
			for (int k = 0; k <= j; k++) {
				if (zigzag[i][k] != null) {
					System.out.println(zigzag[i][k].toString());
					reslut = reslut + zigzag[i][k];
				}
			}
		}
		return reslut;
	}

	public static String convert2(String s, int nRows) {

		int length = s.length();
		if (length <= 1 || nRows == 1) {
			return s;
		}

		String reslut = new String();

		int i = 0;
		int j = 0;
		int[] temp = new int[s.length()];
		while (j < length) {
			temp[i] = j;
			System.out.println(temp[i]);
			j = j + 2 * (nRows - 1);
			i++;
		}

		int flag = 0;
		while (flag < nRows) {
			if (flag == 0) {
				int k = 0;
				while (k < i) {
					reslut = reslut + s.charAt(temp[k]);
					k++;
				}
				System.out.println(reslut);
			} else if (flag == nRows - 1) {
				int k = 0;
				while (k < i) {
					if (temp[k] + nRows - 1 < length) {
						reslut = reslut + s.charAt(temp[k] + nRows - 1);
						System.out.println(s.charAt(temp[k] + nRows - 1));
					}
					k++;
				}
			} else {
				int k = 0;
				while (k < i) {// ³õÊ¼»¯Îª0£¿£¿£¿

					if (temp[k] + flag < length) {
						reslut = reslut + s.charAt(temp[k] + flag);
					}

					if (temp[k] + (nRows * 2 - flag) - 2 < length) {
						reslut = reslut + s.charAt(temp[k] + 2 * nRows - flag - 2);
						System.out.println(s.charAt(temp[k] + 2 * nRows - flag - 2));
					}

					k++;
					System.out.println(k);
				}
			}
			flag++;
		}
		return reslut;
	}

	public static void main(String[] args) {
		System.out.println(convert2("ABCD", 3));
	}
}
