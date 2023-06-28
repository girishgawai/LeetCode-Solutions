package trees;
import java.util.*;

public class Binary_Tree_Level_Order_Traversal_II {
	
//	  Definition for a binary tree node.
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	 
	class Solution {
	    public List<List<Integer>> levelOrderBottom(TreeNode root) 
	    {
	    	List<List<Integer>> ans = new ArrayList<>();
	    	
	    	if(root==null)
	    		return ans;
	    	
	    	Queue<TreeNode> q = new LinkedList<>();
	    	Queue<TreeNode> helper = new LinkedList<>();
	    	List<Integer> list = new ArrayList<>();
	    	while(!q.isEmpty())
	    	{
	    		TreeNode removed = q.remove();
	    		list.add(removed.val);
	    		
	    		if(removed.left!=null)
	    			helper.add(removed.left);
	    		
	    		if(removed.right!=null)
	    			helper.add(removed.right);
	    		
	    		if(q.isEmpty())
	    		{
	    			ans.add(0,list);
	    			list = new ArrayList<>();
	    			q = helper;
	    			helper = new LinkedList<>();
	    		}
	    	}
	    	
	    	return ans;
	    }
	}

}
