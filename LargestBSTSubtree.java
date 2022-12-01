package leetcode.coomplex.code;

public class LargestBSTSubtree {

	//	  Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	class BST_Pair {
		int size = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		boolean isBst = true;
	}
	
	class Solution {
		public int largestBSTSubtree(TreeNode root) {

			return LargestBST_Subtree(root).size;
		}

		private BST_Pair LargestBST_Subtree(TreeNode root) {
			// TODO Auto-generated method stub
			if(root==null)
				return new BST_Pair();
			
			BST_Pair left = LargestBST_Subtree(root.left);
			BST_Pair right = LargestBST_Subtree(root.right);
			
			BST_Pair bst = new BST_Pair();
			bst.max = Math.max(root.val, Math.max(left.max, right.max));
			bst.min = Math.min(root.val, Math.min(left.min, right.min));
			
			if(left.isBst==true && right.isBst==true && left.max<root.val && right.min>root.val)
			{
				bst.isBst = true;
				bst.size = left.size+right.size + 1;
			}
			else
			{
				bst.isBst = false;
				bst.size = Math.max(left.size, right.size);
			}
			
			return bst;
		}
	}

}
