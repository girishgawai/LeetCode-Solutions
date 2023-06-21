package linkedlists;

public class Reverse_Nodes_in_k_Group {
	
//	  Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	 
	class Solution {
	    public ListNode reverseKGroup(ListNode head, int k) {
	    	// base case
	    	if(k==0 || k==1)
	    		return head;
	    	
	    	// counter which will count the len of LL
	    	int count=0;							// so we can perform reverse op on particular LL then make count-k to check next LL
	    	
	    	ListNode dummy = new ListNode();
	    	dummy.next = head;				// will note the head for ans LL and note the starting head adrs
	    	ListNode prev = dummy;						// prev is pointing/holding on dummy adrs
	    	ListNode curr = head, ahead = head;								// in-short sb ka start head se hai
	    	
	    	while(curr!=null)
	    	{
	    		count++;
	    		curr = curr.next;
	    	}
	    	
	    	// ab count me len hai LL ki.. so ab hm ek ek group of LL ko reverse krege and krne k baad count-k krte jayege jb tk
	    	// count>=k rhta hai tb tk.. mtlb 3 size ka LL bcha hai n 3 =k hai toh reverse krege tb tk.. agr k=3 count=2 hai toh nh krege
	    	while(count>=k)
	    	{
	    		curr = prev.next;		// bringing the curr to start of the grouped LL 1st node
	    		ahead = curr.next;		// ahead will be kept on next node that of curr
	    		
	    		// now will perform reverse op on grouped LL until k-1 op.. means 3 elements ka reverse krna hai toh 2 bari krege toh bn jayega
	    		for(int i=1;i<k;i++)
	    		{
	    			curr.next = ahead.next;								// curr point krega ahead k aagle node pe
	    			ahead.next = prev.next;								// ahead point krega phle wale pe means curr pe for reversion
	    			// ab ahead pe prev ko lado.. so woh usko point krega agli nodes ko purane pe path dene k liye
	    			prev.next = ahead;						// ab jha ahead tha woh adrs aya.. prev k nxt me ahead
	    			ahead = curr.next;						// ahead ab point kr rha hai curr ke next pe.. sbse agle node pe
	    		}
	    		
	    		// one complete reverse ho gya mtlb ab
	    		prev = curr;		// mtlb jo curr tha ab woh prev bnega aur ye woh phle wale grouped LL ka last node tha
	    		// sbse phle bari me prev yeh ans LL ka node head hai.. uske baad ab yeh reflect nhi hoga dummy pe kyu ki prev pe nya node adrs overrite hora
	    		
	    		count = count-k;
	    		
	    	}
	    	
	        return dummy.next;				// ab dummy ke next me--> dummy point kra kra hai ans wali LL ka adrs pe
	    }
	}
}
