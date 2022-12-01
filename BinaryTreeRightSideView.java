package leetcode.coomplex.code;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
	
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
		static int depth=-1;
		
	    public List<Integer> rightSideView(TreeNode root) {
	    	depth =-1;
	    	
	    	List<Integer> list = new ArrayList<>();
	        rightView(root,0,list);
	        return list;
	    }

		private void rightView(TreeNode root, int cl, List<Integer> list) {
			// TODO Auto-generated method stub
			if(root==null)
				return;
			
			if(depth<cl)
			{
				list.add(root.val);
				depth=cl;
			}
			rightView(root.right, cl+1, list);
			rightView(root.left, cl+1, list);
		}
	}
}
