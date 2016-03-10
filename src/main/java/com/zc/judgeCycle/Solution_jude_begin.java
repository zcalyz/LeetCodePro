package com.zc.judgeCycle;
//http://www.voidcn.com/blog/qq508618087/article/p-4973281.html
//142 Linked List Cycle II
public class Solution_jude_begin {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		third.next = head;
		head.next = second;
		second.next = third;
		Solution_jude_begin solution = new Solution_jude_begin();
		ListNode detectCycle = solution.detectCycle(head);
	}
	
	public  ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
			return null;
		}
        boolean signal = false;
		ListNode first = head;
		ListNode second = head;
		while(first.next != null && second.next != null && second.next.next != null){
			first = first.next;
			second = second.next.next;
			if(first == second){
				signal = true;
				break;
			}
		}
		if(signal == false){
			return null;
		}
		second = head;
		while(first != second){
			first = first.next;
			second = second.next;
			if(first == second){
				break;
			}
		}	
		return first;
    }
}
