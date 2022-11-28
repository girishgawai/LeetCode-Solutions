package tree.qps;

public class DeleteNodeinaBST {
	
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
	    public TreeNode deleteNode(TreeNode root, int key) {
	    	if(root==null)
	    		return null;
	    	
	    	if(root.val>key)
	    		root.left = deleteNode(root.left, key);
	    	else if(root.val<key)
	    		root.right = deleteNode(root.right, key);
	    	else																// means key-value mil gyi jisko delete krna hai
	    	{
	    		// for child 0 or 1
	    		if(root.left==null)
	    			return root.right;
	    		else if(root.right==null)
	    			return root.left;
	    		else
	    		{								// both 2 dono childs nhi hai null hai
	    			int left_side_max = maximum(root.left);
	    			root.val = left_side_max;							// replacing the key with max on left side
	    			root.left = deleteNode(root.left, left_side_max);		// ab chnage kr di key ko... purani key ke jgah max dal dia and ab max ko key bna dia delete krne	
	    		}
	    		
	    	}
	        return root;
	    }

		private int maximum(TreeNode root) {
			// TODO Auto-generated method stub
			if(root==null)
				return Integer.MIN_VALUE;
			
			int right = maximum(root.right);
			return Math.max(right, root.val);
		}
	}
}
