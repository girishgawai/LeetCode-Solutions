package tree.qps;

public class ValidateBinarySearchTree {

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

	class BestPair {
		long Max = Integer.MIN_VALUE;
		long Min = Integer.MAX_VALUE;
		boolean blnc_status = true;
	}

	class Solution {
		public boolean isValidBST(TreeNode root) {
			return isValid__BST(root).blnc_status;
		}

		public BestPair isValid__BST(TreeNode root) {
			if(root==null)
				return new BestPair();

			BestPair left_Blnc_Pair = isValid__BST(root.left);
			BestPair right_Blnc_Pair = isValid__BST(root.right);

			BestPair ans = new BestPair();
			ans.Min = Math.min(root.val, Math.min(left_Blnc_Pair.Min, right_Blnc_Pair.Min));
			ans.Max = Math.max(root.val, Math.max(left_Blnc_Pair.Max, right_Blnc_Pair.Max));
			
			if(left_Blnc_Pair.blnc_status==true && right_Blnc_Pair.blnc_status==true && root.val>left_Blnc_Pair.Max && root.val<right_Blnc_Pair.Min)
			{
				ans.blnc_status = true;			// valid hai BST


				return ans;
			}
			else
			{

				ans.blnc_status = false;		// status false bhejege ab.. kyu ki tree BST nhi hai
			}
			return ans;
		}
	}
}
