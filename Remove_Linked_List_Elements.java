package linkedlists;

public class Remove_Linked_List_Elements {

	public class ListNode {
		     int val;
		     ListNode next;
		     ListNode() {}
		     ListNode(int val) { this.val = val; }
		     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		 }
	
	class Solution {
		public ListNode removeElements(ListNode head, int val) {
			ListNode prev = new ListNode();
			ListNode head_start = head;
			
			if(head.val==val)								// agr phla hi data LL ka removal hai toh head start pev se hoga
				head_start = prev.next;
			
			ListNode curr = head;
			
			while(curr!=null)
			{
				while(curr!=null && curr.val==val)		// yeh removal element hai so isko remove krege--> jitne removal aye sb remove kro
				{
					curr = curr.next;
				}
				
				if(head_start==null)	// agr woh start_head null hai means usko ab start point allocate kro jb curr non removal pe ho
					head_start = curr;
				
				prev.next = curr;
				prev = curr;
				if(curr!=null)
					curr = curr.next;
			}
			
			return head_start;
		}
	}
}
