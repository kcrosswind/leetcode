package com.bupt.kcrosswind.Leetcode;

public class Solution_ListNodepartition {
    public static ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        ListNode less = null;
        ListNode greater = null;
        ListNode greaterhead = null;
        ListNode reslut = null;
         
        ListNode corsor = head;
        while(corsor != null){
            if(corsor.val < x){
                if(less == null){
                    less = corsor;
                    corsor = corsor.next;
                    less.next = null;
                }else{
                    less.next = corsor;
                    corsor = corsor.next;
                    less = less.next;
                    less.next = null;
                }
                if(reslut == null){
                    reslut = less;
                }
            }else{
                if(greater == null){
                    greater = corsor;
                    corsor = corsor.next;
                    greater.next = null;
                }else{
                    greater.next = corsor;
                    corsor = corsor.next;
                    greater = greater.next;
                    greater.next = null;
                }
                if(greaterhead == null){
                    greaterhead = greater;
                }
            }
        }
        if(less != null && greaterhead != null){
            less.next = greaterhead;
        }else if(greaterhead != null){
            reslut = greaterhead;
        }
        return reslut;
    }
    
    public static void main(String[] args){
    	ListNode head = new ListNode(2);
    	ListNode head1 = new ListNode(1);
    	head.next = head1;
    	
    	ListNode ln = partition(head, 2);
    	
    	while(ln != null){
    		System.out.println(ln.val);
    		ln = ln.next;
    		
    	}
    }
}
