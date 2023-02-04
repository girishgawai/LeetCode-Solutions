package trees;

public class Longest_Univalue_Path {
	
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
		static int max = 0;
		public int longestUnivaluePath(TreeNode root) {
			max = 0;
	        if(root!=null)
	        	longestUniPath(root, root.val);
	        
	        return max;
	    }

		private int longestUniPath(TreeNode root, int data) {
			// TODO Auto-generated method stub
			if(root==null)
				return 0;
			
			int left = longestUniPath(root.left, root.val);
			int right = longestUniPath(root.right, root.val);
			
			int len = left+right;
			max = Math.max(max, len);
			
			if(root.val==data)								// agr parent - child same hai toh usko v add kroge isliye +1
				return Math.max(left, right)+1;
			else
				return 0;									// agr dif dif hai parent child mtlb 0 return krege uss branch se
		}
	}

}
