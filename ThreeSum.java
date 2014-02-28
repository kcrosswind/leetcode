package com.bupt.kcrosswind.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

		ArrayList<ArrayList<Integer>> reslut = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();

		QuickSort(num, 0, num.length - 1);

		int flag = 0;
		while (flag < num.length) {
			if (num[flag] < 0) {
				flag++;
			} else {
				break;
			}
		}

		if (num[flag] == 0 && flag + 2 < num.length && num[flag + 1] == 0 && num[flag + 2] == 0) {
			temp.add(num[flag]);
			temp.add(num[flag]);
			temp.add(num[flag]);
			reslut.add(temp);

		}
		
		

		return reslut;
	}

	public int[] splitPlusMinus(int[] num) {

		int i = 0;
		int j = num.length;

		return num;
	}

	public static int AdjustArray(int[] temp, int start, int end) {

		int cache;
		int flag = start;
		while (start < end) {
			while (temp[end] >= temp[flag] && start < end) {
				end--;
			}
			if (temp[end] < temp[flag]) {
				cache = temp[flag];
				temp[flag] = temp[end];
				temp[end] = cache;
				flag = end;
			}
			while (temp[start] <= temp[flag] && start < end) {
				start++;
			}
			if (temp[start] > temp[flag]) {
				cache = temp[flag];
				temp[flag] = temp[start];
				temp[start] = cache;
				flag = start;
			}
		}

		return flag;

	}

	public static void QuickSort(int[] num, int start, int end) {

		if (start < end) {//递归要有结束标志
			int flag = AdjustArray(num, start, end);

			QuickSort(num, start, flag - 1);
			QuickSort(num, flag + 1, end);
		}

	}

	public static void test() {
		int[] temp = { -1, 1, 6, 5 };
		int start = 0;
		int end = 3;
		QuickSort(temp, start, end);
		System.out.println(temp[0]);
		System.out.println(temp[1]);
		System.out.println(temp[2]);
		System.out.println(temp[3]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		test();
	}

}
