package linkedlists;

public class Delete_Node_in_a_Linked_List {

	public class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) { val = x; }
		 }
	
	class Solution {
		public void deleteNode(ListNode node) 
		{
			ListNode after_now = node.next;
			while(after_now!=null)
			{
				node.val = after_now.val;
				if(after_now.next==null)
				{
					node.next = null;
					break;
				}
				node = after_now;
				after_now = after_now.next;
			}
		}

	}
}