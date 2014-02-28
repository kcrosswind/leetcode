package com.bupt.kcrosswind.Leetcode;

public class Solution_reverseKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null){
			return null;
		}
		ListNode twin = new ListNode(0);
		twin.next = head;
		int count = 0;
		ListNode pre = twin;
		ListNode cursor = head;
		while (cursor != null){
			count++;
			ListNode next = cursor.next;
			if (count == k){
				pre = reverse(pre, next);
				count = 0;
			}
			cursor = next;
		}
		return twin.next;
	}

	private ListNode reverse(ListNode pre, ListNode end){
		if (pre == null || pre.next == null)
			return pre;
		ListNode head = pre.next;
		ListNode cur = pre.next.next;
		while (cur != end){
			ListNode next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = next;
		}
		head.next = end;
		return head;
	}
}
