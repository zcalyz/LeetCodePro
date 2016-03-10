package com.zc.judgeCycle;

public class Solution {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		third.next = head;
		head.next = second;
		second.next = third;
		Solution solution = new Solution();
		solution.hasCycle(head);
	}
	
	public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
			return false;
		}
		ListNode first = head;
		ListNode second = head;
		while(first.next != null && second.next != null && second.next.next != null){
			first = first.next;
			second = second.next.next;
			if(first == second){
				return true;
			}
		}
		return false;
    }
}
