package leetcode.coomplex.code;

import java.util.Arrays;

public class Distinct_Subsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "rabbbit", t = "rabbit";

		System.out.println(possibleCombinations(s,t,0,0));

		/**********   Using Top Down  ***********/


		int[][] dp = new int[s.length()][t.length()];
		for(int[] a : dp)
			Arrays.fill(a, -1);
		System.out.println(possibleCombinations_TD(s,t,0,0,dp));
	}

	/**********   Using Top Down  ***********/
	private static int possibleCombinations_TD(String str1, String str2, int i, int j, int[][] dp) {
		// TODO Auto-generated method stub
		if(str2.length()==j)								// agr str2 khtm ho gye mtlb aage aate aate str1 se match krte
			return 1;								// mtlb str1 se str2 bn gyi ek way me.. so 1 way return kro

		if(str1.length()==i)					// agr str1 khtm ho gye mtlb aage aate aate str2 se match krte.. lekin str2 baki hai av
			return 0;	 		// mtlb str1 me aur koi data nh bcha jo str2 jaise bna skte string so return 0.. nhi bn skta iss trh se

		if(dp[i][j]!=-1)
			return dp[i][j];

		int a = 0;
		int b = 0;
		if(str1.charAt(i)==str2.charAt(j))
			a = possibleCombinations_TD(str1, str2, i+1, j+1,dp);			// consider krege usko lege

		b = possibleCombinations_TD(str1, str2, i+1, j,dp);												// usko nh lege

		return dp[i][j] = a+b;									// total possible ways str1 se str2 ke subseq bnane ke



	}

	private static int possibleCombinations(String str1, String str2, int i, int j) {
		// TODO Auto-generated method stub
		if(str2.length()==j)								// agr str2 khtm ho gye mtlb aage aate aate str1 se match krte
			return 1;								// mtlb str1 se str2 bn gyi ek way me.. so 1 way return kro

		if(str1.length()==i)					// agr str1 khtm ho gye mtlb aage aate aate str2 se match krte.. lekin str2 baki hai av
			return 0;	 		// mtlb str1 me aur koi data nh bcha jo str2 jaise bna skte string so return 0.. nhi bn skta iss trh se



		int a = 0;
		int b = 0;
		if(str1.charAt(i)==str2.charAt(j))
			a = possibleCombinations(str1, str2, i+1, j+1);			// consider krege usko lege

		b = possibleCombinations(str1, str2, i+1, j);												// usko nh lege

		return a+b;									// total possible ways str1 se str2 ke subseq bnane ke
	}

}
 
