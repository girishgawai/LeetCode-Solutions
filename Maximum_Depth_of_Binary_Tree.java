package trees;

public class Maximum_Depth_of_Binary_Tree {
	
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
	    public int maxDepth(TreeNode root) 
	    {
	    	if(root==null)
	    		return 0;
	    	
	    	int left = maxDepth(root.left);
	    	int right = maxDepth(root.right);
	    	
	    	int self = Math.max(left, right) + 1;
	        
	    	return self;
	    }
	}}
