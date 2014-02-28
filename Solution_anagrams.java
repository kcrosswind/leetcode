package com.bupt.kcrosswind.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Solution_anagrams {
	public ArrayList<String> anagrams(String[] strs) {
		String[] strscopy = new String[strs.length];
		ArrayList<String> reslut = new ArrayList<String>();

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (int i = 0; i < strs.length; i++) {
			char[] c = strs[i].toCharArray();
			Arrays.sort(c);
			strscopy[i] = c.toString();
			if (hm.containsKey(strscopy[i])) {
				reslut.add(strs[i]);
				if (hm.get(strscopy[i]) != -1) {
					reslut.add(strs[hm.get(strscopy[i])]);
					hm.put(strscopy[i], -1);
				}
			} else {
				hm.put(strscopy[i], i);
			}
		}
		
		return reslut;
	}

	public static void main(String[] args) {
		// // ArrayList<String> al = new ArrayList<String>("dd");// 我觉得必须要放对象容器
		// ArrayList<Integer> a2 = new ArrayList<Integer>(3);
		// System.out.println(a2);
		// // ArrayList<ArrayList<Integer>> a3 = new ArrayList<Integer>(new
		// // ArrayList<Integer>(3));
		//
		// HashMap hm = new HashMap();
		// hm.put(1, "sss");
		// hm.put(1, "aaa");
		// System.out.println(hm.get(1));

	}
}
