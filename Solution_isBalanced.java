package com.bupt.kcrosswind.Leetcode;

import java.util.HashMap;

public class Solution_isBalanced {

	static HashMap<TreeNode, Integer> temp = new HashMap<TreeNode, Integer>();

	public static boolean isBalanced(TreeNode root) {

		return isBalanced(root, temp);
	}

	public static boolean isBalanced(TreeNode root, HashMap<TreeNode, Integer> temp) {
		if (root == null) {
			temp.put(root, 0);
			System.out.println("hehe");
			return true;
		}

		if (isBalanced(root.left, temp) && isBalanced(root.right, temp)) {
			int diff = temp.get(root.left) + temp.get(root.right);
			if (diff <= 1 && diff >= -1) {
				temp.put(root, 1 + Math.max(temp.get(root.left), temp.get(root.right)));
				System.out.println("haha");
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(3);

		root.left = root1;
		root.right = root2;

		System.out.println(isBalanced(root));
		
		System.out.println(temp);
	}
}
