package com.bupt.kcrosswind.Leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class Solution_removeNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (n == 0) {
			return head;
		}
		if (head.next == null) {
			return null;
		}

		if (n == 1) {
			ListNode pre = null;
			ListNode target = head;

			while (target.next != null) {
				target = target.next;
				if (target == head.next) {
					pre = head;
				} else if (target != head) {
					pre = pre.next;
				}
			}

			pre.next = null;
			return head;
		} else {
			ListNode pre = null;
			ListNode target = head;
			ListNode flag = head.next;

			for (int i = n - 2; i > 0; i--) {
				flag = flag.next;
			}
			while (flag.next != null) {

				target = target.next;
				if (target == head.next) {
					pre = head;
				} else if (target != head) {
					pre = pre.next;
				}
				flag = flag.next;
			}

			if (target == head) {
				head = head.next;
			} else {
				pre.next = target.next;
			}
			return head;
		}
	}
	public static void main(String[] args){
		Stack<Integer> s=new Stack<Integer>();
		s.push(1);
		for(int i:s){
			System.out.println(i);
		}
		LinkedList<Integer> ll=new LinkedList<Integer>();
		ll.isEmpty();
//		s.clear();
		for(int i:s){
			System.out.println(i);
		}
		if(s.isEmpty()){
			System.out.println("kongle");
		}
	}
}
