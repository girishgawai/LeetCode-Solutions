package recurssion;

import java.util.*;

public class Combination_Sum {
	
	    static List<List<Integer>> sol = new ArrayList<>();
	    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
	        sol = new ArrayList<>();
	        List<Integer> list = new ArrayList<>();
			combination(candidates,0,target,"",list);
			return sol;
	    }

	    private static void combination(int[] candidates, int curr, int target, String ans, List<Integer> list) {
			// TODO Auto-generated method stub
			if(target==0)
			{
				sol.add(new ArrayList<>(list));
//				System.out.println(ans);
				return;
			}

			for (int i = curr; i < candidates.length; i++) {
				if(target>=candidates[i])
				{
					list.add(candidates[i]);
					combination(candidates, i, target-candidates[i], ans+candidates[i], list);
					list.remove(list.size()-1);
				}
			}
		}
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {2,3,6,7};
		int target = 7;
		combinationSum(candidates,target);
	}

}
