package tree.qps;

public class DiameterofBinaryTree_OptimisedCode {
	
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
	 
	class DiaPair {						// Daimeter-Height Pair
		int ht=-1;						// initiak values of Ht and D
		int d=0;
	}
	
	class Solution {
	    public int diameterOfBinaryTree(TreeNode root) {
	    	return diameter(root).d;
	    }
	    
	    public DiaPair diameter(TreeNode root)
	    {
	    	if(root==null)
	    		return new DiaPair();
	    	
	    	DiaPair ldp = diameter(root.left);					// left wala diameter uski pair
	    	DiaPair rdp = diameter(root.right);					// right wala diameter uski pair
	    	DiaPair sdp = new DiaPair();						// self ki diameter pair khud se bnne wali.. defualt d=0 ht=-1 rhegi
	    	
	    	sdp.ht = Math.max(ldp.ht, rdp.ht)+1;				// ht nikal li daipair me entire niche bne hue sbse bde tree ki khudse jane wale
	    	int d = ldp.ht+rdp.ht+2;								// diameter khud ke node se bnne wali
	    	
	    	sdp.d = Math.max(d, Math.max(ldp.d, rdp.d));		// jo sbse bdi daimeter hogi whi rkh dege diapair me upr return krne ht/d pair
	    	return sdp;
	    }
	}

}
