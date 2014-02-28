package com.bupt.kcrosswind.Leetcode;

import java.util.ArrayList;

public class Solution_mergeKLists {
	public static ListNode mergeKLists(ArrayList<ListNode> lists) {
		ListNode reslut = null;
		ListNode last = null;
		ListNode head = null;

		while (!lists.isEmpty()) {
			if (lists.get(0) == null) {
				lists.remove(0);
			} else {
				int temp = lists.get(0).val;
				int tempflag = 0;
				for (int i = 0; i < lists.size(); i++) {
					if (lists.get(i) != null) {
						if (temp > lists.get(i).val) {
							temp = lists.get(i).val;
							tempflag = i;
						}
					}
				}
				if (reslut == null) {
					reslut = lists.remove(tempflag);
					head = reslut;
					if (reslut.next != null) {
						lists.add(reslut.next);
					}
				} else {
					reslut.next = lists.remove(tempflag);
					if (reslut.next.next != null) {
						lists.add(reslut.next.next);
					}
					reslut = reslut.next;
				}
			}
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode head1 = new ListNode(2);
		ListNode head2 = new ListNode(5);
		head.next = head1;
		head1.next = head2;
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(head);
		ListNode reslut = mergeKLists(lists);
		while (reslut != null) {
			System.out.println(reslut.val);
			reslut = reslut.next;
		}
		System.out.println();

		String c = new String("abc");
		String d = new String("abc");
		String a = "abc";
		String b = "abc";
		

		if (a == b) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		if (c == d) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		if (a.equals(b)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		if (a == c) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		if (a.equals(c)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
