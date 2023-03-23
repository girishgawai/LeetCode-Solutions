package trees;

public class Sum_of_Left_Leaves {

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
		static int count = 0;								// counts the sum of Left side Leaf Node
		
		public int sumOfLeftLeaves(TreeNode root) {
            count = 0;

          //   if(root.left==null && root.right==null) {
			    // return count;       
          //   }

            sumOfLeftLeafNodes(root);
			return count;
		}
		
		public int sumOfLeftLeafNodes(TreeNode root) {
			if(root.left==null && root.right==null)						// agr woh leaf node rha toh hi hm uss leaf node ki value bhejege
				return root.val;
			
			
			int left = 0;
			if(root.left!=null)
			{
				left = sumOfLeftLeafNodes(root.left);						// ah=gr left side se val aayi 0 means left leaf node nh tha
			}

			// toh add nhi krege val leaf node ki
				count = count + left;			// agr left leaf node se left me value 0 se bdi aayi means left Leaf hai --> add kro value
			
			int right = 0;
			if(root.right!=null)
				right = sumOfLeftLeafNodes(root.right);					// right child me 0 aya means rt child nh tha
//			if(right>0)														
//				count = count + right;			// right ka alg calculate krne ki need nhi bcaz rt ka leaf node nh chahiye
			return 0;					// right se agr koi left me gya hoga child toh woh chahiye-> left wala care lega uss chiz ki
		}
	}

}
