package leetcode.coomplex.code;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	
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
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	    	return buildTheTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);	        
	    }

		private TreeNode buildTheTree(int[] preorder, int plo, int phi, int[] inorder, int ilo, int ihi) {
			// TODO Auto-generated method stub
			if(plo>phi || ilo>ihi)
				return null;
			
			
			TreeNode node = new TreeNode(preorder[plo]);
			int idx = linearSearch(preorder[plo],inorder,ilo,ihi);
			int tni = idx-ilo;									// total nodes in inorder before idx found
			node.left = buildTheTree(preorder, plo+1, plo+tni, inorder, ilo, idx-1);
			node.right = buildTheTree(preorder, plo+tni+1, phi, inorder, idx+1, ihi);
			
			
			return node;
		}

		private int linearSearch(int item, int[] inorder, int si, int ei) {
			// TODO Auto-generated method stub
			for (int i = si; i <= ei; i++) {
				if(item==inorder[i])
					return i;
			}
			return 0;
		}
	}

}
