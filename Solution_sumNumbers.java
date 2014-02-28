package com.bupt.kcrosswind.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_sumNumbers {

	public int sumNumbers(TreeNode root) {
		if(root==null){
			return 0;
		}
		List<String> list = new ArrayList<String>();
		String temp = new String();
		dfs(list, temp, root);

		int reslut = 0;
		for (String s : list) {
			reslut = reslut + Integer.valueOf(s);
		}
		return reslut;
	}

	public void dfs(List<String> list, String temp, TreeNode root) {
		if (root != null) {
			temp = temp + root.val;
		}
		if (root.left == null && root.right == null) {
			list.add(temp);
		}
		if (root.left != null) {
			dfs(list, temp, root.left);
		}
		if (root.right != null) {
			dfs(list, temp, root.right);
		}
	}
}
