package linkedlists;

public class Swap_Nodes_in_Pairs {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	class Solution {
		public ListNode swapPairs(ListNode head) 
		{
			ListNode Head = new ListNode();
			if(head==null)
				return head;

			if(head.next!=null)
				Head = head.next;
			else
				return head;

			ListNode curr = head;
			ListNode prev = new ListNode();

			ListNode old_prev = head;
			int count = 1;
			while(curr!=null)
			{
				prev = curr;
				if(curr.next==null)
					return Head;

				curr = curr.next;

				prev.next = curr.next;
				curr.next = prev;

				if(count!=1)
				{	
					old_prev.next = curr;		// older previous which was pointing on prev_older from where we need to point this current.. kyu ki samne ke 3/4 ki loc chng hue bt phle ki 1 k nxt pe 3 tha.. lekin rhna chahiye 4
					old_prev = curr.next;			// older_previous ko v toh aage bdhayege.. next chain ke satrt pe
				}
				curr = prev.next;
				count++;
			}
			
			return Head;
		}
	}
}
