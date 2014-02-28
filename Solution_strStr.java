package com.bupt.kcrosswind.Leetcode;

public class Solution_strStr {
	// 暴力法
	public static String strStr(String haystack, String needle) {
		int i = 0;

		int hlength = haystack.length();
		int nlength = needle.length();

		if (nlength == 0) {
			return haystack;
		} else {
			while (i <= hlength - nlength) {
				int j = 0;
				while (j < nlength) {
					if (haystack.charAt(i + j) != needle.charAt(j)) {
						break;
					} else if (j == nlength - 1) {
						return haystack.substring(i);
					}
					j++;
				}
				i++;
			}
			return null;
		}

	}

	// kmp算法 ，效率极低
	public static String strStrKMP(String haystack, String needle) {

		int nlength = needle.length();
		if (nlength == 0) {
			return haystack;
		}

		// int[] form = KMPform(needle);
		int[] form = KMPformjuly(needle);
		int hlength = haystack.length();

		int i = 0;//需要跳转i，所以用while
		while (i <= hlength - nlength) {
			int j = 0;
			while (j < nlength) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					if (j == 0) {
						i++;
					} else {
						i = i + j - form[j - 1];
					}
					break;
				} else if (j == nlength - 1) {
					return haystack.substring(i);// 左闭右开
				}
				j++;
			}
		}
		return null;

	}

	public static int[] KMPform(String str) {
		int[] form = new int[str.length()];
		for (int i = 0; i < form.length; i++) {
			int j = i;

			while (j > 0) {
				if (str.substring(0, j).equals(str.substring(i - j + 1, i + 1))) {
					form[i] = j;
					break;
				}

				j--;
			}
			if (j == 0) {
				form[i] = 0;
			}
		}
		return form;
	}

	public static int[] KMPformjuly(String str) {
		//
		// int[] form = new int[str.length()];
		// form[0] = -1;
		// for (int i = 1; i < form.length; i++) {
		//
		// if (str.charAt(form[i - 1] + 1) == str.charAt(i)) {
		// form[i] = form[i - 1] + 1;
		// } else {
		// int j = form[i - 1];
		// while (j > 0) {
		// if (str.substring(0, j).equals(str.substring(i - j + 1, i + 1))) {
		// form[i] = j;
		// break;
		// }
		//
		// j--;
		// }
		// if (j == 0) {
		// form[i] = -1;
		// }
		// }
		// }
		// return form;

		int[] form = new int[str.length()];
		form[0] = -1;
		for (int i = 1; i < form.length; i++) {
			int index = form[i - 1];
			while (index >= 0 && str.charAt(i) != str.charAt(index + 1)) {
				index = form[index];// 完全不懂原理是不是以最后两位为基准一直往上推？？？
			}
			if (str.charAt(i) == str.charAt(index + 1)) {
				form[i] = index + 1;// =form[i-1]+1//实际上是不对的 还是要用index+1
			}
			else {
				form[i] = -1;
			}
		}
		return form;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1 };
		String s = "mississippi";
		String ss = "issip";

		String sss = "ABCDABD";
		int[] f = KMPformjuly(sss);
		System.out.println(f.length);
		for (int i = 0; i < f.length; i++) {
			System.out.println(f[i]);
		}

		System.out.println(strStrKMP(s, ss));
	}
}
