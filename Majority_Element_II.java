package hashmap;

import java.util.*;

public class Majority_Element_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,3};
		System.out.println(majorityElement(nums).toString());
	}

	public static List<Integer> majorityElement(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(!map.containsKey(nums[i]))
				map.put(nums[i], 0);
			
			map.put(nums[i], map.get(nums[i])+1);
		}
		
		List<Integer> list = new ArrayList<>();
		int limit = nums.length/3;			// occurrence of each element must be less than this .. n/3.. then only it is majority elm
		for(int key : map.keySet())
		{
			if(map.get(key)>limit)
				list.add(key);
		}
		
		return list;
	}
}
