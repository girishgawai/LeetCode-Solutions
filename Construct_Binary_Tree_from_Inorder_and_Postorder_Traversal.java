package leetcode.coomplex.code;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	
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
	    public TreeNode buildTree(int[] inorder, int[] postorder) {
	        return construct(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
	    }

	    private TreeNode construct(int[] post, int plo, int phi, int[] in, int ilo, int ihi) {
				// write your code here
				if(ilo>ihi || plo>phi)
					return null;
				
				TreeNode nn = new TreeNode(post[phi]);
				int idx = linearSearch(post[phi], in, ilo, ihi);			// inorder[] me jis index pe item mila
				int tnbp = idx-ilo;
				
				
				nn.left = construct(post, plo, plo+tnbp-1, in, ilo, idx-1);
				nn.right = construct(post, plo+tnbp, phi-1, in, idx+1, ihi);
				
//				node.left = construct(post, plo, plo - ilo + idx - 1, in, ilo, idx - 1);
//				node.right = construct(post, phi - ihi + idx, phi - 1, in, idx + 1, ihi);
				
				return nn;
			}

			private int linearSearch(int item, int[] in, int ilo, int ihi) {
				// TODO Auto-generated method stub
				for (int i = ilo; i <= ihi; i++) {
					if(item==in[i])
						return i;
				}
				
				return 0;
			}
	    
	}
}
