package com.bupt.kcrosswind.Leetcode;

public class Solution_hasPathSum {
	/*
	 * �ǳ���Ҫ ��һֱ����дdfs 
	 * �����return�͵� Ӧ��return���ҵĺϲ�������������� 
	 * root==null�Լ��ж� ����������
	 */
	public static boolean hasPathSum(TreeNode root, int sum) {

		int temp = 0;
		int target = sum;
		return dfs(root, temp, target);
	}

	public static boolean dfs(TreeNode root, int temp, int target) {
		if (root == null) {
			return false;
		}
		temp = temp + root.val;
		System.out.println(temp);
		if (root.left == null && root.right == null && temp == target) {
			return true;
		} else {
			return dfs(root.left, temp, target) || dfs(root.right, temp, target);
		}

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode root1 = new TreeNode(2);
		root.left = root1;

		System.out.println(hasPathSum(root, 3));
	}
}
