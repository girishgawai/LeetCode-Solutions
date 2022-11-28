package tree.qps;

public class SumRoottoLeafNumbers {
	
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
	    public int sumNumbers(TreeNode root) {
	    	return sum(root, 0);
	    }

		private int sum(TreeNode root, int pathSum) {
			// TODO Auto-generated method stub
			if(root==null)
				return 0;
			
			if(root.left==null && root.right==null)
				return pathSum*10 + root.val;
			
			int leftSum = sum(root.left, pathSum*10 + root.val);
			int rightSum = sum(root.right, pathSum*10 + root.val);
			
			return leftSum+rightSum;
		}
	}
}
