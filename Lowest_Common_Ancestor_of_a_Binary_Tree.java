package leetcode.coomplex.code;

public class Lowest_Common_Ancestor_of_a_Binary_Tree {
	
//	  Definition for a binary tree node.
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	class Solution {
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    	if(root==null)
	    		return null;
	    	
	    	if(root==p || root==q)
	    		return root;
	    	
	    	TreeNode left = lowestCommonAncestor(root.left, p, q);
	    	TreeNode right = lowestCommonAncestor(root.right, p, q);
	    	
	    	if(left!=null && right!=null)			// mtlb rt wala child(q) v mil gya and left wala (p) v mil gya node root pe uss
	    		return root;
	    	else if(left==null)
	    		return right;
	    	else
	    		return left;
	        
	    }
	}
}
