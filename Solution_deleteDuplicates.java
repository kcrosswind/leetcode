package com.bupt.kcrosswind.Leetcode;

import java.util.Arrays;

public class Solution_deleteDuplicates {
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode temp = new ListNode(0);
		temp.next = head;
		ListNode pre = temp;
		ListNode cursor = head;
		while (cursor != null && cursor.next != null) {
			if (cursor == cursor.next) {
				while (cursor == cursor.next) {
					cursor = cursor.next;
				}
				pre.next = cursor.next;
				cursor = cursor.next;
				System.out.println("hehe");
			} else {
				System.out.println("hehe");
				pre = pre.next;
				cursor = cursor.next;
			}
		}
		return temp.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode head1 = new ListNode(1);
		head.next = head1;
		ListNode result = deleteDuplicates(head);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
		int[] A = { 1, 2, 3 };
		int[] B = { 4, 5, 6 };
		A = Arrays.copyOf(B, 2);
		for (int i : A) {
			System.out.println(i);
		}
	}
}
