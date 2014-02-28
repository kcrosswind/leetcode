package com.bupt.kcrosswind.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution_levelOrderBottom {
	public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}
		LinkedList<TreeNode> queue0 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();

		queue0.addFirst(root);
		while (!queue0.isEmpty() || !queue1.isEmpty()) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			while (!queue0.isEmpty()) {// isempty he !=null buyiyang
										// !!!!!!!!!!!!!
				TreeNode temp = queue0.removeLast();
				al.add(temp.val);
				if (temp.left != null) {
					queue1.addFirst(temp.left);
				}
				if (temp.right != null) {
					queue1.addFirst(temp.right);
				}
			}
			if (!al.isEmpty()) {
				result.add(al);
				al.clear();
			}
			while (!queue1.isEmpty()) {
				TreeNode temp = queue1.removeLast();
				al.add(temp.val);
				if (temp.left != null) {
					queue0.addFirst(temp.left);
				}
				if (temp.right != null) {
					queue0.addFirst(temp.right);
				}
			}
			if (!al.isEmpty()) {
				result.add(al);
				al.clear();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(9);
		levelOrderBottom(root);
	}
}
