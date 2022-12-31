package leetcode.coomplex.code;

import java.util.Arrays;

public class House_Robber {
	public static void main(String[] args) {
//		int[] arr = {1,2,3,1};
		int[] arr = {2,7,9,3,1};
		
//		System.out.println(rob(arr,0));						// normal Recursion
		System.out.println(rob(arr,arr.length-1));		// agr pichese ghar lutna chalu krte ayege				// normal Recursion
		
		int[] dp = new int[arr.length];						// memorize krne k liye ans ko agr wapis same chiz solve krni rhi toh
		
		Arrays.fill(dp, -1);					/* default 0 nhi rhne dia bcaz of CONSTRAINSTS */ // 0 v money rhe skti hai ghar me
		System.out.println(robTD(arr, 0, dp));	 							// DP --> Top Down DP
		
		
		System.out.println(robBU(arr)); 											// DP --> Bottom Up DP
	}

											
	private static int robBU(int[] arr) {						// DP --> Bottom Up DP iterative way
		// TODO Auto-generated method stub
		 if(arr.length==1)
	            return arr[0];                  // agr ek hi element hai array me toh whi ans hoga return krdo..  mtlb usi ghar ko luto
		
		int[] dp = new int[arr.length];
		
		// kyu ki hmne array me tran=verse krte time jha khade hai usse piche wale dekhte jayege ulta
		dp[0] = arr[0];				// Base condition
		dp[1] = Math.max(arr[0], arr[1]);				// Base condition
		
		for (int i = 2; i < dp.length; i++) {
			int rob = dp[i-2]+arr[i];
			int not_rob = dp[i-1];
			dp[i] = Math.max(rob, not_rob);
		}
		
		return dp[arr.length-1];					// dp[] me last index pe hi sbse greater value rhegi
	}


	private static int robTD(int[] arr, int i, int[] dp) {	 							// DP --> Top Down DP
		// TODO Auto-generated method stub
		if(i>=arr.length)
			return 0;
									// already default array me -1 dala hua hai.. default 0 nhi rhne dia bcaz of CONSTRAINSTS
		if(dp[i]!=-1)								// agr dp[] me -1 ke alawa aur kuch v hoga mtlb ans mila tha iska phle khi so use dp
			return dp[i];											// purane ans ko use kro findout hoga toh
		
		int rob = robTD(arr, i+2, dp) + arr[i];
		int not_rob = robTD(arr, i+1, dp);
		
		return dp[i] = Math.max(rob, not_rob);							// memorize krna
	}


//	private static int rob(int[] arr, int i) {				// --->  normal Recursion
//		// TODO Auto-generated method stub
//		if(i>=arr.length)
//			return 0;
//													// jis ghar ko rob kia usko v mila lo
//		int rob = rob(arr, i+2)+arr[i];				// manlo phla ghar rob kia hai.. toh ab +2 se hi rob krna pdega wrna alarm bjega
//		int not_rob = rob(arr, i+1);				// manlo phla ghar rob NHI kia hai.. toh ab +1 se hi rob krna pdega wrna alarm bjega
//		
//		int max = Math.max(rob, not_rob);						// sbse jaada kisne lute.. rob krke +2 jane wale ne.. ya bina rob 
//																			// krke +1 se rob krna start krne wale ne
//		
//		return max;					// dono me se jisne sbse jaada lute hoge usko return kro
//	}
	
	// manlo pichese last ghar se lutna chalu krege toh piche se phle ghar tk lutte hue ayege
	private static int rob(int[] arr, int i) {				// --->  normal Recursion
		// TODO Auto-generated method stub
		if(i<0)
			return 0;
													// jis ghar ko rob kia usko v mila lo
		int rob = rob(arr, i-2)+arr[i];				// manlo phla ghar rob kia hai.. toh ab +2 se hi rob krna pdega wrna alarm bjega
		int not_rob = rob(arr, i-1);				// manlo phla ghar rob NHI kia hai.. toh ab +1 se hi rob krna pdega wrna alarm bjega
		
		int max = Math.max(rob, not_rob);						// sbse jaada kisne lute.. rob krke +2 jane wale ne.. ya bina rob 
																			// krke +1 se rob krna start krne wale ne
		
		return max;					// dono me se jisne sbse jaada lute hoge usko return kro
	}
	
	
	
}
