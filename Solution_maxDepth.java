package com.bupt.kcrosswind.Leetcode;

public class Solution_maxDepth {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left != null && root.right != null) {
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
		}
		if (root.left != null) {
			return 1 + maxDepth(root.left);
		}
		if (root.right != null) {
			return 1 + maxDepth(root.right);
		}
		return 1;
	}
}
