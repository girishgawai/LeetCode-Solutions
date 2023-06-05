package linkedlists;

public class Remove_Duplicates_from_Sorted_List {

//	  Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	 
	class Solution {
	    public ListNode deleteDuplicates(ListNode head) 
	    {
	    	// agr ek hi element hai ya fir ek b element nhi hai list me
	    	if(head==null || head.next==null)
				return head;
	    	
	    	ListNode prev = head;
	    	ListNode curr = prev.next;
	    	
	    	while(curr!=null)
	    	{
	    		while(curr!=null && curr.val==prev.val)
	    		{
	    			curr = curr.next;
	    		}
	    		
	    		prev.next = curr;
	    		prev = curr;
	    		
	    		// agr curr pe null aya hai toh curr ko next pe nhi kr skte acess uss case me curr ko aage mt bdhao
	    		if(curr!=null)											// agr current ka next null nhi hai means curr ko aage push kro
	    			curr = curr.next;
	    	}
	        
	    	return head;
	    }
	}

}
