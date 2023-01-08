package leetcode.coomplex.code;

import java.util.Arrays;

public class Minimum_Falling_Path_Sum_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] matrix = {{ 1,2,3 }, { 4,5,6 }, { 7, 8, 9 }};
		int[][] dp = new int[matrix.length][matrix.length];
		for(int[] a : dp)
			Arrays.fill(a, -1);
		
		int ans = Integer.MAX_VALUE;
		for (int col = 0; col < matrix[0].length; col++) {
			ans = Math.min(ans, minFallingPathSum(matrix, 0, dp, col));
		}						
		System.out.println(ans);
	}

	private static int minFallingPathSum(int[][] matrix, int row, int[][] dp, int freezecol) {
		// TODO Auto-generated method stub
		if(freezecol<0 || freezecol>=matrix[0].length)
			return Integer.MAX_VALUE;
		
		if(row==matrix.length-1)
		{
			return matrix[row][freezecol];
		}
		
		if(dp[row][freezecol]!=-1)
			return dp[row][freezecol];
		
		int ans = Integer.MAX_VALUE;	// used to store less sum value of the falling path
		for(int i=0; i<matrix[0].length; i++)		// [][] ke col pe loop lgaya --> har ek col me jayega isse always starts from 0
		{																				// for each row
			if(i!=freezecol)
				ans = Math.min(ans, minFallingPathSum(matrix, row+1, dp, i));
		}
		
		return dp[row][freezecol] = matrix[row][freezecol] + ans;
				
	}

}
 
