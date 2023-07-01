package trees;

public class Minimum_Depth_of_Binary_Tree {
	
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
	    public int minDepth(TreeNode root) 
	    {
	    	if(root==null)
	    		return 0;
	    	
	    	int left = minDepth(root.left);
	    	int right = minDepth(root.right);
	    	
	    	int self_depth = 0;
	    	if(left==0 && right==0)			// agr dono lft rt branches nhi hai means self ki value 1 hogi			
	    		self_depth = 1;
	    	else if(left==0 || right==0)		// agr left OR right dono me se koi v ek 0 hai mtlb left+right krdo aur +1 khudka			
	    		self_depth = left+right + 1;
	    	else
	    		self_depth = Math.min(left, right) + 1;	// agr dono v 0 nhi hai mtlb dono ke branches hai toh unko add kro +1 depth hogi
	        return self_depth;
	    }
	}

}
