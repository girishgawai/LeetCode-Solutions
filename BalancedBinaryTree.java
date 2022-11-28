package leetcode.coomplex.code;

public class BalancedBinaryTree {
	
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
	    public boolean isBalanced(TreeNode root) {
	    	if(root==null)
	    		return true;
	    	
	    	boolean lb = isBalanced(root.left);
	    	boolean rb = isBalanced(root.right);
	    	
	    	boolean sb = Math.abs(heightOfTree(root.left) - heightOfTree(root.right)) <=1;	// -1 0 1 rha toh balance hai tree
	    	return lb && rb && sb;
	    }

		private int heightOfTree(TreeNode root) {
			// TODO Auto-generated method stub
			if(root==null)
				return -1;
			
			int lht = heightOfTree(root.left);
			int rht = heightOfTree(root.right);
			
			return Math.max(rht, lht) + 1;
		}
	}
}
