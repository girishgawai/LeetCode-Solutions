package leetcode.coomplex.code;

import java.util.Arrays;

public class Coin_Change_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int amount = 5;
		int[] coins = {1,2,5};
		
		// Using Normal Recursion
//		System.out.println(possibleCombinations(amount, coins, 0));				// 0 for iteration on coin array
		
		// Using Top Down Recursion
		int[][] dp = new int[coins.length][amount+1];
		for(int[] a : dp)
		{
			Arrays.fill(a, -1);
		}
		System.out.println(possibleCombinations(amount, coins, 0, dp));
	}
	
	// Using Top Down Recursion
	private static int possibleCombinations(int amount, int[] coins, int i, int[][] dp) {
		// TODO Auto-generated method stub
		if(amount==0)
			return 1;
		
		if(coins.length==i)		// agr coins hi khtm ho gye toh 0 return krde.. 0 ways of combinations bnege amount khtm krne ke
			return 0;
		
		if(dp[i][amount]!=-1)			// Using DP.. Purani yaade beeti baate.. old exprnc ans is needed once again
			return dp[i][amount];
		
		// agr coin bda hai nd amount choti hai toh return 0 krege bcaz ab pick nh kr skte hai.. kyu ki amount -ve bn jayegi fir toh
		// Agr amount bdi hai ya coin ki jitni hai toh coin pick krege.. agr amount choti hai coins se toh dusre coin lege isko nhi pick krege
		int coinPicked = 0;
		if(amount>=coins[i])
		{
			coinPicked = possibleCombinations(amount-coins[i], coins, i,dp);	// uss coin ko pick kia toh amount se minus v krge price.. nd next coin pe jate but unlimites source hai toh whi coin wapis v pick kr skte
		}
		int coinNotPick = possibleCombinations(amount, coins, i+1,dp);			// next coin pick krna hai agr skip kr dia phle wala pick krna toh
		
		return dp[i][amount] = coinNotPick + coinPicked;		// MEMORIZE
	}

	// Using Normal Recursion
	private static int possibleCombinations(int amount, int[] coins, int i) {
		// TODO Auto-generated method stub
		if(amount==0)
			return 1;
		
		if(coins.length==i)		// agr coins hi khtm ho gye toh 0 return krde.. 0 ways of combinations bnege amount khtm krne ke
			return 0;
		
		// agr coin bda hai nd amount choti hai toh return 0 krege bcaz ab pick nh kr skte hai.. kyu ki amount -ve bn jayegi fir toh
		// Agr amount bdi hai ya coin ki jitni hai toh coin pick krege.. agr amount choti hai coins se toh dusre coin lege isko nhi pick krege
		int coinPicked = 0;
		if(amount>=coins[i])
		{
			coinPicked = possibleCombinations(amount-coins[i], coins, i);	// uss coin ko pick kia toh amount se minus v krge price.. nd next coin pe jate but unlimites source hai toh whi coin wapis v pick kr skte
		}
		int coinNotPick = possibleCombinations(amount, coins, i+1);			// next coin pick krna hai agr skip kr dia phle wala pick krna toh
		
		return coinNotPick + coinPicked;
	}

}
