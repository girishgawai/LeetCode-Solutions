package trees;

public class Convert_Sorted_Array_to_Binary_Search_Tree {
	
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
	    public TreeNode sortedArrayToBST(int[] nums) 
	    {
	    	TreeNode root = createBST(nums,0,nums.length-1);
	        return root;
	    }

		private TreeNode createBST(int[] nums, int si, int ei) 
		{
			if(si>ei)
				return null;
			
			int mid = (si+ei)/2;
			TreeNode nn = new TreeNode();
			nn.val = nums[mid];
			
			nn.left = createBST(nums, si, mid-1);
			
			nn.right = createBST(nums, mid+1, ei);
			
			return nn;
		}
	}
}
