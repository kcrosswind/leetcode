package com.bupt.kcrosswind.Leetcode;

import java.util.Stack;

public class Solution_isValidBST {
	public boolean isValidBST(TreeNode root) {
		return isValidBSTR(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

	}

	public boolean isValidBSTR(TreeNode root, int min, int max) {// java
																	// 参数传递的都是引用
																	// 所以只能改变的是传参的值

		if (root == null) {
			return true;
		}

		if (root.val <= min || root.val >= max) {
			return false;
		}
		return isValidBSTR(root.left, min, root.val) && isValidBSTR(root.right, root.val, max);// 递归的返回很有讲究
		// 递归的精髓在于返回的一定是一个相同规模的函数，而不是运行相同规模的函数
	}

	public static boolean isValidBSTnoR(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		if (root != null) {
			s.push(root);
		} else {
			return true;
		}

		TreeNode temp = root;
		TreeNode nutemp;
		int pre = Integer.MIN_VALUE;
		while (!s.isEmpty()) {
			while (temp.left != null) {
				s.push(temp.left);
				nutemp = temp.left;
				temp.left = null;
				temp = nutemp;
			}
			temp = s.pop();
			if (temp.val <= pre) {
				return false;
			}
			pre = temp.val;

			if (temp.right != null) {
				s.push(temp.right);
				temp = temp.right;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(34);
		TreeNode p1 = new TreeNode(-6);
		TreeNode p2 = new TreeNode(-21);
		TreeNode p3 = new TreeNode(-21);
		TreeNode p4 = new TreeNode(2);
		TreeNode p5 = new TreeNode(4);
		TreeNode p6 = new TreeNode(6);

		root.left = p1;
		// root.right = p2;
		p1.left = p3;
		// p1.right = p4;
		// p2.left = p5;
		System.out.println(isValidBSTnoR(root));
	}
}