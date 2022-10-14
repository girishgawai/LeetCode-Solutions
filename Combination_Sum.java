package leetcode.coomplex.code;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub			// source is unlimited --> the number of candidates can be pick 'n' number of times
		int[] candidates = {2,3,6,7};
		int target = 7;
		
//		formPermutations(candidates,target, 0, "");
		
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> ans = new ArrayList<>();
		formCombinations(candidates,target, 0, "", 0, list, ans);    // last zero form performing combinations of unlimited source
		
		System.out.println(ans);
	}

	// it will form all the combinations without having repeated/Permutations
	private static void formCombinations(int[] candidates, int target, int sum, String ans, int last, List<Integer> list, List<List<Integer>> ansS) {
		// TODO Auto-generated method stub
		if(sum==target)
		{
//			System.out.println(ans);
//			System.out.println(list);
			ansS.add(new ArrayList<>(list));// kyu ki backtracking me hm original list se hi uda rhe hai items toh final ansS list v udega
			return;											// isliye ek nyi arrayList me se store kr rhe ansS list me so addrs alg rhega
		}														// har bar nhi ArrayList me list dalkr ansS me ayega toh data erase nhi hoga
		
		if(sum>target)
			return;
		
		for (int i = last; i < candidates.length; i++) {	// source unlimited hai isliye next call v ussi call se jayega jha se phla wala gya tha
			list.add(candidates[i]);
			formCombinations(candidates, target, sum+candidates[i], ans+candidates[i], i, list, ansS);			// combinations bnane ke liye
			list.remove(list.size()-1);
		}
		
	}
	
	// it will form all the possible permutations
	private static void formPermutations(int[] candidates, int target, int sum, String ans) {
		// TODO Auto-generated method stub
		if(sum==target)
		{
			System.out.println(ans);
			return;
		}
		
		if(sum>target)
			return;
		
		for (int i = 0; i < candidates.length; i++) {
			formPermutations(candidates, target, sum+candidates[i], ans+candidates[i]);
		}
		
	}

}
