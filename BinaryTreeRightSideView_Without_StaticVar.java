package leetcode.coomplex.code;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView_Without_StaticVar {
	
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
	 
	class Vsited_Level {
		int depth = -1;
	}
	
	class Solution {
		
	    public List<Integer> rightSideView(TreeNode root) {
	    	
	    	List<Integer> list = new ArrayList<>();
	        rightView(root,0,list, new Vsited_Level());
	        return list;
	    }

		private void rightView(TreeNode root, int cl, List<Integer> list, Vsited_Level d) {
			// TODO Auto-generated method stub
			if(root==null)
				return;
			
			if(d.depth<cl)
			{
				list.add(root.val);
				d.depth=cl;
			}
			rightView(root.right, cl+1, list, d);
			rightView(root.left, cl+1, list, d);
		}
	}
}
