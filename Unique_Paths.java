package dp_recursion;

import java.util.Arrays;

public class Unique_Paths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 3, n = 7;
		
//		int ans = uniquePaths(m-1,n-1,0,0);
		int[][] dp = new int[m][n];
		for(int[] a : dp)
			Arrays.fill(a, -1);
		int ans = uniquePaths_TD(m-1, n-1, 0, 0, dp);
		System.out.println(ans);
	}

	private static int uniquePaths_TD(int m, int n, int row, int col, int[][] dp) {
		// TODO Auto-generated method stub
		if(row>m || col>n)
			return 0;
		
		if(row==m && col==n)
			return 1;
		
		if(dp[row][col]!=-1)
			return dp[row][col];
		
		int right = uniquePaths_TD(m, n, row, col+1, dp);
		int down = uniquePaths_TD(m, n, row+1, col, dp);
		
		return dp[row][col] = right+down;
	}
	
	
	private static int uniquePaths(int m, int n, int row, int col) {
		// TODO Auto-generated method stub
		if(row>m || col>n)
			return 0;
		
		if(row==m && col==n)
			return 1;
		
		int right = uniquePaths(m, n, row, col+1);
		int down = uniquePaths(m, n, row+1, col);
		
		return right+down;
	}

}
