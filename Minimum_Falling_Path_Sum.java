package leetcode.coomplex.code;

import java.util.Arrays;

public class Minimum_Falling_Path_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
		int[][] dp = new int[matrix.length][matrix.length];
		for(int[] a : dp)
			Arrays.fill(a, -1);
		
		int ans = Integer.MAX_VALUE;
		for (int col = 0; col < matrix[0].length; col++) {
			ans = Math.min(ans, minFallingPathSum(matrix, 0, col, dp));
		}						
		System.out.println(ans);
	}

	private static int minFallingPathSum(int[][] matrix, int row, int col, int[][] dp) {
		// TODO Auto-generated method stub
		if(col<0 || col>=matrix[0].length)
			return Integer.MAX_VALUE;
		
		if(row==matrix.length-1)
		{
			return matrix[row][col];
		}
		
		if(dp[row][col]!=-1)
			return dp[row][col];
		
		int down = minFallingPathSum(matrix, row+1, col, dp);
		int downLt = minFallingPathSum(matrix, row+1, col-1, dp);
		int downRt = minFallingPathSum(matrix, row+1, col+1, dp);
		
		return dp[row][col] = matrix[row][col] + Math.min(down, Math.min(downLt, downRt));
		// uss pos ka num initial count woh uss index ka data khud rhega
	}

}
