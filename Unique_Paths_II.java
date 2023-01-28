package dp_recursion;

import java.util.Arrays;

public class Unique_Paths_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
//		int[][] grid = {{0,0},{0,1}};

		int[][] dp = new int[grid.length][grid[0].length];
		for(int[] a : dp)
			Arrays.fill(a, -1);
		int ans = uniquePaths_TD(grid, 0, 0, dp);
		System.out.println(ans);
		
//		int ansss = uniquePaths(grid, 0, 0);
//		System.out.println(ansss);
	}

	private static int uniquePaths_TD(int[][] grid, int row, int col, int[][] dp) {
		// TODO Auto-generated method stub
		if(row>=grid.length || col>=grid[0].length)
			return 0;

		if(grid[row][col]==1)
			return 0;
		
		if(row==grid.length-1 && col==grid[0].length-1)
			return 1;

		if(dp[row][col]!=-1)
			return dp[row][col];


		int right = uniquePaths_TD(grid, row, col+1, dp);
		int down = uniquePaths_TD(grid, row+1, col, dp);

		return dp[row][col] = right+down;
	}


	private static int uniquePaths(int[][] grid, int row, int col) {
		// TODO Auto-generated method stub
		if(row>=grid.length || col>=grid[0].length)
			return 0;
		
		if(grid[row][col]==1)
			return 0;

		if(row==grid.length-1 && col==grid[0].length-1)
		{
			return 1;
		}

		int right = uniquePaths(grid, row, col+1);
		int down = uniquePaths(grid, row+1, col);

//		System.out.println(right + "=======" + down);
		return right+down;
	}

}
