package leetcode.coomplex.code;

public class Merge_Two_Sorted_Lists {
	
//	  Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	 
	class Solution {
	    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	    	ListNode ans = new ListNode();
	    	ListNode temp = ans;
	    	
	    	ListNode lh1 = list1;
	    	ListNode lh2 = list2;
	    	while(lh1!=null && lh2!=null)
	    	{
	    		if(lh1.val>lh2.val)
	    		{
	    			temp.next = lh2;
	    			lh2 = lh2.next;
	    			temp = temp.next;
	    		}
	    		else
	    		{
	    			temp.next = lh1;
	    			lh1 = lh1.next;
	    			temp = temp.next;
	    		}
	    	}
	        
	    	if(lh1!=null)
	    		temp.next = lh1;
	    	
	    	if(lh2!=null)
	    		temp.next = lh2;
	    	
	    	return ans.next;
	    }
	}
}
