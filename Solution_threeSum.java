package com.bupt.kcrosswind.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Solution_threeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> reslut = new ArrayList<ArrayList<Integer>>();
		if (num.length < 3) {
			return reslut;
		}

		int length = num.length;
		for (int sursor = 0; sursor < length - 2; sursor++) {
			if (sursor == 0 || num[sursor] > num[sursor - 1]) {
				int left = sursor + 1;
				int right = num.length - 1;
				int target = 0 - num[sursor];
				while (left < right) {
					if (num[left] + num[right] == target) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num[sursor]);
						temp.add(num[left]);
						temp.add(num[right]);
						reslut.add(temp);
						left++;
						right--;
						while (left < right && num[left] == num[left + 1]) {
							left++;
						}
						while (left < right && num[right] == num[right - 1]) {
							right--;
						}
					}
					while (left < right && num[left] + num[right] < target) {
						left++;
					}
					while (left < right && num[left] + num[right] > target) {
						right--;
					}
				}
			}
		}
		return reslut;
	}

	public void twoSum(int[] num, int target, int sursor, ArrayList<ArrayList<Integer>> reslut) {
		int left = sursor + 1;
		int right = num.length - 1;

		while (left < right) {

			if (num[left] + num[right] == target) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(num[sursor]);
				temp.add(left);
				temp.add(right);
				Collections.sort(temp);
				reslut.add(temp);
				left++;
				right--;
			}
			while (left < right && num[left] + num[right] < target) {
				left++;
			}
			while (left < right && num[left] + num[right] > target) {
				right--;
			}
		}

	}

	public static void main(String[] args) {
		HashSet<int[]> hs = new HashSet<int[]>();
		int[] i = { 1, 2, 3 };
		int[] i1 = { 1, 2, 3 };// butong
		hs.add(i1);
		hs.add(i);
		for (int[] flag : hs) {
			System.out.println(flag.toString());
		}
		if (!i.equals(i1)) {
			System.out.println("true");
		}

		HashSet<ArrayList<Integer>> hs1 = new HashSet<ArrayList<Integer>>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		al1.add(1);
		al1.add(2);
		al1.add(3);
		hs1.add(al);
		hs1.add(al1);
		for (ArrayList<Integer> flag : hs1) {
			System.out.println(flag.toString());
		}
	}

}
