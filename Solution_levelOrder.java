package com.bupt.kcrosswind.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_levelOrder {
	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> reslut = new ArrayList<ArrayList<Integer>>();
		//队列的使用！！！
		Queue<TreeNode> ll = new LinkedList<TreeNode>();
		if (root != null) {
			// ArrayList<Integer> temp = new ArrayList<Integer>();
			// temp.add(root.val);
			// reslut.add(temp);
			ll.add(root);
		}
		System.out.println(ll.peek().val);
		while (!ll.isEmpty()) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			int length = ll.size();
			for (int i = 0; i < length; i++) {
				TreeNode tn = ll.poll();
				temp.add(tn.val);
				if (tn.left != null) {
					ll.add(tn.left);
				}
				if (tn.right != null) {
					ll.add(tn.right);
				}
			}
			reslut.add(temp);
		}
		return reslut;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		root.left = left;
		TreeNode right = new TreeNode(3);
		root.right = right;
		levelOrder(root);
		System.out.println(levelOrder(root));

	}
}
