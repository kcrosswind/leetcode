package com.bupt.kcrosswind.Leetcode;

import java.util.ArrayList;

/*Combinations
 *Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 */
/*这个不会 看得
*/
public class Solution_combine {

	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> reslut = new ArrayList<ArrayList<Integer>>();
		// for (int i = 1; n - i + 1 >= k; i++) {//duociyiju
		// ArrayList<Integer> temp = new ArrayList<Integer>();
		// dfs(reslut, temp, 1, n, k, 0);
		// }
		ArrayList<Integer> temp = new ArrayList<Integer>();
		dfs(reslut, temp, 1, n, k, 0);
		return reslut;
	}

	// dfs
	public static void dfs(ArrayList<ArrayList<Integer>> reslut, ArrayList<Integer> temp, int elementNum, int n, int k,
			int currentnumber) {
		if (currentnumber == k) {
			reslut.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = elementNum; i <= n; i++) {
			temp.add(i);
			// System.out.println(temp.get(0));
			currentnumber++;
			dfs(reslut, temp, i + 1, n, k, currentnumber);
			temp.remove(temp.size() - 1);
			currentnumber--;// 简直无语
		}
	}

	public static void main(String[] args) {
		System.out.println(combine(2, 1));
	}
}
