package com.bupt.kcrosswind.Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_connect {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			root.next = null;
			return;
		}
		LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.addFirst(root);
		while (!queue.isEmpty()) {
			TreeLinkNode temp = queue.removeLast();
			if (temp.left != null) {
				queue.addFirst(temp.left);
				queue.addFirst(temp.right);
			}
			if (!queue.isEmpty()) {
				temp.next = queue.getFirst();
			}
		}
		root.next = null;
		while (root.right != null) {
			root = root.right;
			root.next = null;
		}
		
		int[] num = {1,2,3};
		int[] num1 = num.clone();
	}
}
