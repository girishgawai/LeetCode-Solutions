package trees;

import java.util.*;

public class Find_Mode_in_Binary_Search_Tree {
	
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
	    public int[] findMode(TreeNode root) 
	    {
	    	
	    	HashMap<Integer, Integer> map = new HashMap<>();
	    	traverse(root, map);
//	    	System.out.println(map);
	    	int max = 0;
	    	for(int key : map.keySet())
	    	{
	    		max = Math.max(max, map.get(key));
	    	}
	    	List<Integer> list = new ArrayList<>();
	    	for(int key : map.keySet())
	    	{
	    		if(map.get(key)==max)
	    			list.add(key);
	    	}
	    	int[] ans = new int[list.size()];
	    	for (int j = 0; j < ans.length; j++) {
				ans[j] = list.get(j);
			}
	    	return ans;
	    }
	    
	    public void traverse(TreeNode root, HashMap<Integer, Integer> map)
	    {
	    	if(root==null)
	    		return;
	    	
	    	if(!map.containsKey(root.val))
	    		map.put(root.val, 1);
	    	else
	    		map.put(root.val, map.get(root.val)+1);
	    	
	    	traverse(root.left, map);
	    	traverse(root.right, map);
	    	
	    }
	}
}
