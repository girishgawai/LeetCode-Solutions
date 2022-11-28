package tree.qps;

public class DiameterofBinaryTree {
	
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
	    public int diameterOfBinaryTree(TreeNode root) {
	    	if(root==null)
	    		return 0;
	    	
	    	int selfD = heightOfTree(root.left) + heightOfTree(root.right) +2 ;
	    	int leftD = diameterOfBinaryTree(root.left);
	    	int rightD = diameterOfBinaryTree(root.right);
	    	
	    	return Math.max(selfD, Math.max(leftD, rightD));	        
	    }
	    
	    
	    private int heightOfTree(TreeNode nn) {
			// TODO Auto-generated method stub
			if(nn==null)
				return -1;						// if given to take hieght of single node tree = 1 then return 0
															// if 0 then return -1		
			
			int leftHT = heightOfTree(nn.left);
			int rightHT = heightOfTree(nn.right);
			
			return Math.max(leftHT, rightHT) + 1;			// Plus 1 krege usme khud ki height daalne k liye
		}
	}
}
