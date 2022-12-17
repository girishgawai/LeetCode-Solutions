package leetcode.coomplex.code;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_k_Sorted_Lists {
	
//	  Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	 
	class Solution {
	    public ListNode mergeKLists(ListNode[] lists) {
	    	
	    	PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {

				@Override
				public int compare(ListNode o1, ListNode o2) {		// kyu ki Generic PQ bnaya hai listnode ek adrs hai jo compare nh ho 
					// TODO Auto-generated method stub					// skte isliye khud ka compare method bnana pdega Comparator se
					
					return o1.val - o2.val;
				}
			});
	    	
	    	for(ListNode node : lists)
	    	{
	    		if(node!=null)
	    			pq.add(node);
	    	}
	    	
	    	ListNode dummy = new ListNode();
	    	ListNode temp = dummy;
	    	
	    	while(!pq.isEmpty())
	    	{
	    		ListNode node = pq.poll();
	    		temp.next = node;
	    		temp = temp.next;
	    		
	    		if(node.next!=null)
	    			pq.add(node.next);
	    	}
	        
	    	return dummy.next;
	    }
	}
}
