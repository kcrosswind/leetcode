package com.bupt.kcrosswind.Leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// �������ڵ� 
class BTNode {
	private char key;
	private BTNode left, right;

	public BTNode(char key) { // �½�һ��ֵΪkey�Ľ��
		this(key, null, null);
	}

	public BTNode(char key, BTNode left, BTNode right) {
		this.key = key; // �½�һ����㣬��ָ�������ҽ��
		this.left = left;
		this.right = right;
	}

	public char getKey() { // ���ؽ���ֵ
		return key;
	}

	public void setKey(char key) { // �趨����ֵ
		this.key = key;
	}

	public BTNode getLeft() { // ���������ӽ��
		return left;
	}

	public BTNode getRight() { // �������Һ��ӽ��
		return right;
	}

	public void setLeft(BTNode left) {// �趨�����ӽ��
		this.left = left;
	}

	public void setRight(BTNode right) {// �趨���Һ��ӽ��
		this.right = right;
	}
}

// ����������
public class BinTree {
	protected BTNode root;

	public BinTree(BTNode root) {
		this.root = root;
	}

	public BTNode getRoot() {
		return root;
	}

	// ������
	public static BTNode init() {
		BTNode a = new BTNode('A');
		BTNode b = new BTNode('B', null, a);
		BTNode c = new BTNode('C');
		BTNode d = new BTNode('D', b, c);
		BTNode e = new BTNode('E');
		BTNode f = new BTNode('F', e, null);
		BTNode g = new BTNode('G', null, f);
		BTNode h = new BTNode('H', d, g);
		return h; // ���ظ����
	}

	// ���ʽڵ�
	public static void visit(BTNode p) {
		System.out.print(p.getKey() + " ");
	}

	// �ݹ�ʵ��ǰ�����
	protected static void preorder(BTNode p) {
		if (p != null) {
			visit(p);
			preorder(p.getLeft());
			preorder(p.getRight());
		}
	}

	// �ݹ�ʵ���������
	protected static void inorder(BTNode p) {
		if (p != null) {
			inorder(p.getLeft());
			visit(p);
			inorder(p.getRight());
		}
	}

	// �ݹ�ʵ�ֺ������
	protected static void postorder(BTNode p) {
		if (p != null) {
			postorder(p.getLeft());
			postorder(p.getRight());
			visit(p);
		}
	}

	// �ǵݹ�ʵ��ǰ�����
	protected static void iterativePreorder(BTNode p) {
		Stack<BTNode> stack = new Stack<BTNode>();
		if (p != null) {
			stack.push(p);
			while (!stack.empty()) {
				p = stack.pop();
				visit(p);
				// ���ӽ���Ƚ�ջ�����ӽ���ٽ�ջ�������ȷ��ʵ������ӽ��
				if (p.getRight() != null)
					stack.push(p.getRight());
				if (p.getLeft() != null)
					stack.push(p.getLeft());
			}
		}
	}

	/*
	 * �ǵݹ�ʵ�ֺ������ ���������һ�����ӽ�㣬�����е����ӽ�������ջ����һ��ѭ�����̣� ��ʱpָ��������Ǹ����ӽ�㣬
	 * �ظ�����pû�����ӽ�㣨����p�����ӽ���Ѿ�������������p��ͬʱ��ջ����ֵ����p ��p�����ӽ�㣬��p��ջ��ͬʱpָ�������ӽ��
	 * �ظ����ϲ��裬ֱ��pΪ��
	 */
	protected static void iterativePostorder(BTNode p) {
		BTNode q = p;
		Stack<BTNode> stack = new Stack<BTNode>();
		while (p != null) {
			// ���е����ӽ�������ջ���������һ��
			while (p.getLeft() != null) {
				stack.push(p);
				p = p.getLeft();
			}
			// ��ǰ�ڵ������ӽ������ӽ���Ѿ����
			while (p.getRight() == null || p.getRight() == q) {
				visit(p);
				q = p;// ��¼��һ��������ڵ�
				if (stack.empty())
					return;
				p = stack.pop();
			}
			// �������ӽ��
			stack.push(p);// ��������whileѭ��û��ִ�У���ô�˴���ջ���������һ�����ӽ��
			p = p.getRight();// ����p�����ӽ��ض�����Ϊ��
		}
	}

	// �ǵݹ�ʵ���������
	protected static void iterativeInorder(BTNode p) {
		Stack<BTNode> stack = new Stack<BTNode>();
		while (p != null) {
			while (p != null) {
				if (p.getRight() != null)
					stack.push(p.getRight());// ��ǰ���ӽ����ջ
				stack.push(p);// ��ǰ�ڵ���ջ
				p = p.getLeft();
			}
			p = stack.pop();
			while (!stack.empty() && p.getRight() == null) {
				visit(p);
				p = stack.pop();
			}
			visit(p);
			if (!stack.empty())
				p = stack.pop();
			else
				p = null;
		}
	}

	public static void preOrderR(TreeNode root) {
		if (root != null) {
			System.out.println(root.val);
			if (root.left != null) {
				preOrderR(root.left);
			}
			if (root.right != null) {
				preOrderR(root.right);
			}
		}
	}

	public static void pastOrderR(TreeNode root) {
		if (root != null) {
			if (root.left != null) {
				pastOrderR(root.left);
			}
			if (root.right != null) {
				pastOrderR(root.right);
			}
			System.out.println(root.val);
		}
	}

	public static void inOrder(TreeNode root) {
		if (root != null) {
			if (root.left != null) {
				inOrder(root.left);
			}
			System.out.println(root.val);
			if (root.right != null) {
				inOrder(root.right);
			}
		}
	}

	public static void levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root != null) {
			queue.add(root);
		}
		TreeNode temp;
		while (!queue.isEmpty()) {
			temp = queue.remove();
			System.out.println(temp.val);
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	public static void main(String[] args) {
		// BinTree tree = new BinTree(init());
		// System.out.print("ǰ�����:");
		// preOrderR(init());
		// preorder(tree.getRoot());
		// System.out.print("/n�������:");
		// inorder(tree.getRoot());
		// System.out.print("/n�������:");
		// postorder(tree.getRoot());
		// // ����Ϊ�ǵݹ����������
		// System.out.print("/n/nǰ�����:");
		// iterativePreorder(tree.getRoot());
		// System.out.print("/n�������:");
		// iterativeInorder(tree.getRoot());
		// System.out.print("/n�������:");
		// iterativePostorder(tree.getRoot());

		TreeNode root = new TreeNode(1);
		TreeNode root1 = new TreeNode(2);
		TreeNode root2 = new TreeNode(3);
		TreeNode root3 = new TreeNode(4);
		TreeNode root4 = new TreeNode(5);

		root.left = root1;
		root.right = root2;
		root1.left = root3;
		root1.right = root4;

		preOrderR(root);
		pastOrderR(root);
		inOrder(root);
		levelOrder(root);
	}
}