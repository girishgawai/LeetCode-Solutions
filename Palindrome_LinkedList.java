package leetcode.coomplex.code;

public class Palindrome_LinkedList {
	
//	  Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	 
	class Solution {
	    public boolean isPalindrome(ListNode head) {
	  
			ListNode slow = head;
			ListNode fast = head;
			ListNode preSlow = null;						// to note the exact location before mid
			
			while(fast!=null && fast.next!=null)
			{
				preSlow=slow;
				slow = slow.next;
				fast = fast.next.next;
			}
			
			ListNode mid = slow;			//	 mid form where half list rev  --> curr
			
			// REverse after mid
			ListNode nn = new ListNode(0, null);
			ListNode prev = null;
			
			while(mid!=null)
			{
				ListNode ahead = mid.next;
				mid.next = prev;
				prev = mid;
				mid=ahead;
			}
			
			// REstore reverse part of list after mid to original list at from mid point
			if(preSlow!=null)
				preSlow.next = prev;			// prev is the head/start of reverse list --> jisko mid se phle ke next me dalna hai
															// reverse list ko mid ke jgah se replace krdena

			
			// Checking Palindrome or not
			ListNode start = head;				// start of list
			ListNode start_mid = prev;				// start of reversed list at mid
			while(start!=null && start!=prev)
			{
				if(start.val!=start_mid.val)
					return false;
				
				start=start.next;
				start_mid=start_mid.next;
			}
			
			return true;
		}
	}
}
