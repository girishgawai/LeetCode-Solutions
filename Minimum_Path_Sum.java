package leetcode.coomplex.code;

import java.util.Arrays;

public class Minimum_Path_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,2,3},{4,5,6}};
		
//		System.out.println(minPathSum(grid, 0, 0));
		
		/************ Top Down ************/
		int[][] dp = new int[grid.length][grid[0].length];
		for(int[] a : dp)
		{
			Arrays.fill(a, -1);
		}
		
		System.out.println(minPathSumTD(grid, 0, 0, dp));
	}
	
	/************ Top Down ************/
	public static int minPathSumTD(int[][] grid, int r, int c, int[][] dp)
	{
		if(r==grid.length-1 && c==grid[0].length-1)
			return grid[r][c];
		
		if(c>=grid[0].length || r>=grid.length)
			return Integer.MAX_VALUE;
		
		if(dp[r][c]!=-1)
			return dp[r][c];
		
		int right = minPathSumTD(grid, r, c+1, dp);
		int down = minPathSumTD(grid, r+1, c, dp);
		
		return dp[r][c] = grid[r][c] + Math.min(right, down);
	}

//	public static int minPathSum(int[][] grid, int r, int c)
//	{
//		if(r==grid.length-1 && c==grid[0].length-1)
//			return grid[r][c];
//		
//		if(c>=grid[0].length || r>=grid.length)
//			return Integer.MAX_VALUE;
//		
//		int right = minPathSum(grid, r, c+1);
//		int down = minPathSum(grid, r+1, c);
//		
//		return grid[r][c] + Math.min(right, down);
//	}
}
