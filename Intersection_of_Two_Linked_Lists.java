package leetcode.coomplex.code;

public class Intersection_of_Two_Linked_Lists {
	
//	   Definition for singly-linked list.
	   public class ListNode {
	       int val;
	       ListNode next;
	       ListNode(int x) {
	           val = x;
	           next = null;
	       }
	   }
	  
	public class Solution {
	    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        
	    	ListNode a = headA;						// first linkedlist starting point node
	    	ListNode b = headB;						// second linkedlist starting point node
	    	
	    	while(a!=b)
	    	{
	    		if(a!=null)
	    			a = a.next;
	    		else
	    			a = headB;
	    		
	    		if(b!=null)
	    			b = b.next;
	    		else
	    			b = headA;
	    	}
	    	
	    	return a;									// return a or b anythiing --> it will be intersectional node point
	    }
	}
	
}
