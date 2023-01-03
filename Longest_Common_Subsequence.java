package leetcode.coomplex.code;

import java.util.Arrays;

public class Longest_Common_Subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text1 = "abcde", text2 = "ace" ;
//		String text1 = "abc", text2 = "abc" ;
//		String text1 = "abc", text2 = "def" ;
//		int longestcomsubeqLen = longestCommonSubsequence(text1, text2, 0, 0);		// str1 start index & str2 start index
//		System.out.println(longestcomsubeqLen);
		
		/*********** Using Top Down Approach ***********/
		int[][] dp = new int[text1.length()][text2.length()];
		// -1 default me fill kia hai.. bcaz default 0 rkhte lekin ans can be 0 agr koi v subseq nh hota toh
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		int longestcomsubeqLen = longestCommonSubsequenceTD(text1, text2, 0, 0, dp);		// str1 start index & str2 start index
		System.out.println(longestcomsubeqLen);
		
		/***********  using Bottom Up Approach  ***********/
//		int longestcomsubeqLen = longestCommonSubsequenceBU(text1, text2);		// str1 start index & str2 start index
//		System.out.println(longestcomsubeqLen);
	}

	// using normal Recursion
	public static int longestCommonSubsequence(String text1, String text2, int t1_idx, int t2i_dx) {
		if(t1_idx>= text1.length() || t2i_dx>=text2.length())
			return 0;
		
		if(text1.charAt(t1_idx)==text2.charAt(t2i_dx))		// agr dono ke chars match ho jate means +1 return krdo subseq bnta skta hai ek
		{																	// subseq me contribute dekr ja skta hai yeh
			return 1 + longestCommonSubsequence(text1, text2, t1_idx+1, t2i_dx+1);	// aur next chars se dono strings bhej dege aage subseq bnta kya kisi aur ka check krne k liye
		}
		
		int len1 = longestCommonSubsequence(text1, text2, t1_idx, t2i_dx+1);
		int len2 = longestCommonSubsequence(text1, text2, t1_idx+1, t2i_dx);

		return Math.max(len1, len2);
	}
	
	// using Top Down Approach
		public static int longestCommonSubsequenceTD(String text1, String text2, int i, int j, int[][] dp) {
			if(i>= text1.length() || j>=text2.length())
				return 0;
			
			if(text1.charAt(i)==text2.charAt(j))		// agr dono ke chars match ho jate means +1 return krdo subseq bnta skta hai ek
			{																	// subseq me contribute dekr ja skta hai yeh
				return 1 + longestCommonSubsequenceTD(text1, text2, i+1, j+1, dp);	// aur next chars se dono strings bhej dege aage subseq bnta kya kisi aur ka check krne k liye
			}
			
			if(dp[i][j]!=-1)				// agr dp[][] ki value -1 se kuch aur hai means uska ans mila hua hai so use krlo
				return dp[i][j];				// -1 default me fill kia hai.. bcaz default 0 rkhte lekin ans can be 0 agr koi v subseq nh hota toh
			
			int len1 = longestCommonSubsequenceTD(text1, text2, i, j+1, dp);
			int len2 = longestCommonSubsequenceTD(text1, text2, i+1, j, dp);

			return dp[i][j] = Math.max(len1, len2);
		}
		
		// using Bpttom Up Approach
		public static int longestCommonSubsequenceBU(String s1, String s2) {
			int[][] dp = new int[s1.length() + 1][s2.length() + 1];
			for (int i = 1; i < dp.length; i++) {
				for (int j = 1; j < dp[0].length; j++) {
					if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
						dp[i][j] = 1 + dp[i - 1][j - 1];
					} else {
						int f = dp[i - 1][j];
						int s = dp[i][j - 1];
						dp[i][j] = Math.max(f, s);
					}

				}

			}

			return dp[dp.length - 1][dp[0].length - 1];
		}
}
