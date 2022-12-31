package leetcode.coomplex.code;

import java.util.Arrays;

public class Min_Cost_Climbing_Stairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {1,100,1,1,1,100,1,1,100,1};
		int[] arr = {10,15,20};
		
		int sf = minCostClimbingStairs(arr,0);				// --->  normal Recursion  -->  starts from 1 st stair
		int ss = minCostClimbingStairs(arr,1);				// --->  normal Recursion  -->  starts from 2 nd stair
		System.out.println(Math.min(sf, ss));					// dono me se jiski cost sbse cum whi ans min cost se staris climb krna
	
		// using DP
		int[] dp = new int[arr.length];
		Arrays.fill(dp, -1);
		int fsTD = minCostClimbingStairsTD(arr, 0, dp);
//		Arrays.fill(dp, -1);							// optional
		int ssTD = minCostClimbingStairsTD(arr, 1, dp);
		System.out.println(Math.min(fsTD,ssTD));					// DP --> Top Down Approach
	
		
		// DP  -->  Bottom UP Approach  -  Iterative Way
		System.out.println(minCostClimbingStairsBU(arr));
		
	}

											/*  --->   DP --> Bottom UP Approach */
	private static int minCostClimbingStairsBU(int[] arr) {
		// TODO Auto-generated method stub
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		dp[1] = arr[1];
		
		for (int i = 2; i < dp.length; i++) {			// ulte chlte ayege hm.. jaise i=3 pe hai toh 3 ko 2 se compare krege then 2 ko 1 se, so on..
			int fs = dp[i-2];
			int ss = dp[i] = dp[i-1];
			dp[i] = Math.min(fs, ss) + arr[i];
		}
		
		return Math.min(dp[dp.length-1], dp[dp.length-2]);
	}

											/*  --->   DP --> Top Down Approach  */
	private static int minCostClimbingStairsTD(int[] arr, int i, int[] dp) {					// DP --> Top Down Approach
		// TODO Auto-generated method stub
		if(i>=arr.length)
			return 0;
		
		if(dp[i]!=-1)
			return dp[i];						// using old result if its already find out.. applying DP
		
		int sf = minCostClimbingStairsTD(arr, i+1, dp);
		int ss = minCostClimbingStairsTD(arr, i+2, dp);
		
		return dp[i] = Math.min(sf, ss)+arr[i];							// memorization
	}

											/*  --->  normal Recursion  */
	private static int minCostClimbingStairs(int[] arr, int i) {				// --->  normal Recursion
		// TODO Auto-generated method stub
		if(i>=arr.length)
			return 0;
		
		int startFirst = minCostClimbingStairs(arr, i+2);
		int startSecond = minCostClimbingStairs(arr, i+1);
		
		return Math.min(startFirst, startSecond) + arr[i];	   		   // jiski cost minimum hogi usme add krege.. starting ki stair cost
	}

	
}
