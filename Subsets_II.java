package leetcode.coomplex.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {
	public static void main(String[] args) {
		int[] nums = {4,4,4,1,4};
		List<List<Integer>> ansList = new ArrayList<>();
		// IMP //
		Arrays.sort(nums);											// phle hi sort krlo agr .. descending order me hoga toh
												// acc to the test case answers.. pura data[] ko ascending me sort krlo then subsets bnao
		
		subsetNonDuplicate(nums,0,"", new ArrayList<>(), ansList);
		System.out.println(ansList);
	}

	private static void subsetNonDuplicate(int[] nums, int i, String ans, List<Integer> list, List<List<Integer>> ansList) {
		// TODO Auto-generated method stub
		ansList.add(new ArrayList<>(list));
//			System.out.println(list);
		
		/// yha pe if() me i==nums.length check krne ki jarurat hi nhi hai.. kyu ki loop hi base condition bn jayega same as that of
		
		
		for (int j = i; j < nums.length; j++) {
			if(i!=j && nums[j]==nums[j-1])
				continue;
			
			list.add(nums[j]);
			subsetNonDuplicate(nums, j+1, ans+" "+nums[j], list, ansList);
			list.remove(list.size()-1);
		}
		
	}
}
