package bitmasking;
import java.util.HashMap;

public class Find_the_Duplicate_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,3,4,2,2};

		System.out.println(findDuplicate(arr));			// using hashmap solution
		
		System.out.println(findDuplicate_Optimized(arr));			// Floyed Cycle algo --> Best solution
		
//		System.out.println(findDuplicate_Optimized_BitMAsking(arr));			// Bit Manipulation
	}
	
//	// bit masking sol
//	public static int findDuplicate_Optimized_BitMAsking(int[] nums) {
//		// DIMAK LGAO.. Bit masking se kro optimized way find krke
//	}

	// Floyed Cycle algo	-->	Best optimized solution
	public static int findDuplicate_Optimized(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];
		
		while(true)
		{
			slow = nums[slow];
			fast = nums[nums[fast]];
			
			if(slow==fast)									// cycle jha detecet hogi.. means intersection point
				break;
		}
		
		int ptr1 = slow;
		int ptr2 = nums[0];
		
		while(ptr1!=ptr2)
		{
			ptr1 = nums[ptr1];
			ptr2 = nums[ptr2];
		}
		
		
		return ptr1;
	}

	// using hashmap
	public static int findDuplicate(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(!map.containsKey(nums[i]))
				map.put(nums[i], 0);
			
			map.put(nums[i], map.get(nums[i])+1);
		}
		
		for(int key : map.keySet())
		{
			if(map.get(key)!=1)
			{
				return key;
			}
		}
		
		return 0;
	}
}
