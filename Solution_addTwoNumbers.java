package com.bupt.kcrosswind.Leetcode;

public class Solution_addTwoNumbers {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode getListNode(int[] nodevalue) {

		int flag = 0;
		int size = nodevalue.length;
		ListNode temp = new ListNode(0);
		ListNode reslut = temp;

		while (flag < size) {
			temp.val = nodevalue[flag];
			if (flag != size - 1) {
				temp.next = new ListNode(0);
				temp = temp.next;
			}
			flag++;
		}
		return reslut;
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode temp = new ListNode(0);
		ListNode l3 = new ListNode(0);
		l3.next = temp;

		int flag = 0;

		while (l1 != null || l2 != null) {

			if (l1 == null) {
				temp.val = temp.val + l2.val;// zhemezuobuxing?
				System.out.println("l2.value" + l3.next.next.val);
				l2 = l2.next;

			} else if (l2 == null) {
				temp.val = temp.val + l1.val;
				System.out.println("l1.value" + l1.val);
				l1 = l1.next;
			} else {
				temp.val = temp.val + l1.val + l2.val;
				l1 = l1.next;
				l2 = l2.next;

				// if ((l1.val + l2.val) / 10 >= 1 && (l1.val + l2.val) % 10 >=
				// 0) {
				//
				// flag = 1;
				//
				// temp.val = (l1.val + l2.val) % 10;
				// System.out.println(temp.val);
				//
				// l1 = l1.next;
				// l2 = l2.next;
				//
				// } else {
				// temp.val = l1.val + l2.val;
				// // temp.next = null;
				// l1 = l1.next;
				// l2 = l2.next;
				// // System.out.println(l2.val);
				// }

			}

			if (temp.val / 10 >= 1 && temp.val % 10 >= 0) {

				temp.val=temp.val%10;
				flag=1;
			}
			if (l1 != null || l2 != null || flag == 1) {// luojiyouwenti未必和break有关
				// System.out.println(temp.val);

				if (flag == 1) {
					temp.next = new ListNode(1);
					flag = 0;
				} else {
					temp.next = new ListNode(0);
				}
				temp = temp.next;
			}
		}
		// temp = null;
		return l3.next;
	}

	public static void main(String args[]) {

		int[] haha = { 9, 9 };
		ListNode l1 = getListNode(haha);
		int[] hehe = { 9 };
		ListNode l2 = getListNode(hehe);
		// l2.next = new ListNode(6);
		// l2.next.next = new ListNode(4);

		ListNode l3 = addTwoNumbers(l1, l2);

		while (l3 != null) {
			System.out.println("->" + l3.val);
			l3 = l3.next;
		}

	}
}
