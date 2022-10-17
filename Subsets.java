package leetcode.coomplex.code;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	static List<List<Integer>> subsetL = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subsetL = new ArrayList<>();
		
		int[] nums = {1,2,3};
		
		subsetPrint(nums,0,"", new ArrayList<>());
		System.out.println(subsetL);
	}

	private static void subsetPrint(int[] nums, int i, String ans, List<Integer> list) {
		// TODO Auto-generated method stub
		if(i==nums.length)
		{
//			System.out.println(list);
			subsetL.add(new ArrayList<>(list));
			return;
		}
		
		subsetPrint(nums, i+1, ans, list);
		list.add(nums[i]);
		subsetPrint(nums, i+1, ans+""+nums[i], list);
		list.remove(list.size()-1);
		
	}

}
