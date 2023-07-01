package trees;

public class Balanced_Binary_Tree {
	
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
		    public boolean isBalanced(TreeNode root) 
		    {
		    	if(root==null)
		    		return true;
		    	
		    	boolean left = isBalanced(root.left);
		    	boolean right = isBalanced(root.right);
		    	
		    	boolean balanceOrNot = false;
		    	if(Math.abs(height(root.left)-height(root.right)) <= 1)		// -1 0 1 rha toh hi balanced hai..3,5,-2,-6,6 ke liye nhi
		    		balanceOrNot = true;
		    	
		    	return balanceOrNot;
		    }
		    
		    public int height(TreeNode root)
		    {
		    	if(root==null)
		    		return -1;
		    	
		    	int left_HT = height(root.left);
		    	int right_HT = height(root.right);
		    	
		    	int self_HT = Math.max(left_HT, right_HT) + 1;
		    	return self_HT;
		    }

			
		}



}
