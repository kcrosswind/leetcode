package com.bupt.kcrosswind.Leetcode;

public class Solution_copyRandomList {
	// public static RandomListNode copyRandomList(RandomListNode head) {
	// RandomListNode root = null;
	// if (head != null) {
	// root = copy(head);
	// }
	// return root;
	// }

	// public static RandomListNode copy(RandomListNode head) {//结点做多了
	//
	// RandomListNode root = new RandomListNode(head.label);
	// if (head.next != null) {
	// root.next = copy(head.next);
	// }
	// if (head.random != null) {
	// root.random = copy(head.random);
	// }
	// return root;
	// }
	//


	public static RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}

		RandomListNode flag = head;
		while (flag != null) {
			RandomListNode temp = new RandomListNode(flag.label);
			temp.next = flag.next;
			flag.next = temp;
			flag = temp.next;
		}

		RandomListNode flag1 = head;
		while (flag1 != null) {
			if (flag1.random != null) {
				flag1.next.random = flag1.random.next;
			}
			flag1 = flag1.next.next;
		}

		RandomListNode reslut = head.next;
		RandomListNode temp = head.next;
		head.next = temp.next;
		head = temp.next;
		while (temp != null && temp.next != null) {

			RandomListNode temp1 = temp.next.next;
			temp.next = temp.next.next;
			temp = temp1;
			
			head.next = temp.next;
			head = temp.next;
		}

		return reslut;
	}
	
	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(-1);
		RandomListNode head1 = new RandomListNode(-1);

		head.next = head1;

		RandomListNode root = copyRandomList(head);
		while (root != null) {
			System.out.println(root.label);
			root = root.next;
		}
	}
}
