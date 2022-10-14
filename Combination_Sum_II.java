package leetcode.coomplex.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {
															 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {10,1,2,7,6,1,5};	// source is Limited
		int target = 8;
		
		List<List<Integer>> ans = new ArrayList<>();
		
		Arrays.sort(candidates); 		// phle hi array ko sort krliya.. agr phla wala no ka call gya hai.. toh ab wapis uska call na jana
		formCombinations(candidates,target,0,new ArrayList<Integer>(),ans, 0);	// source is Limited--> thats why next call will start from
																//// last called index
		System.out.println(ans);
	}

	private static void formCombinations(int[] candidates, int target, int sum, List<Integer> list, List<List<Integer>> ans, int last) {
		// TODO Auto-generated method stub
		if(target==sum)
		{
			ans.add(new ArrayList<>(list));
			return;
		}
		
		if(sum>target)
			return;
		
		
		for (int j = last; j < candidates.length; j++) {// so calling next fun frame call from one next .. phle wale se aage se call krege
			
			// aagr dono ke index same rhe last&j ke toh perfrom na ho.. BCAZ arr[j-1] krne se -1ve index aa skta hai
			if(j!=last && candidates[j]==candidates[j-1])	// agr phle wala no iss wale no ke bra hai toh call mt kr.. next element pe jar call try kr
			{														// AND agr index same NHI hai j aur last ka toh hi call kr
				continue;													// same index rha toh out of bound ja skta hai -1 krne se
			}
			list.add(candidates[j]);
			formCombinations(candidates, target, sum+candidates[j], list, ans, j+1);		// limited source and need to find combinations
			list.remove(list.size()-1);
		}
		
	}

}
