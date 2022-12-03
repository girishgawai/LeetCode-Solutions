package leetcode.coomplex.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(longestConsecutive(arr));
	}

	public static int longestConsecutive(int[] nums) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) 
		{
			if(!map.containsKey(nums[i]))			// agr map me yeh key exist nhi krti
			{
				if(map.containsKey(nums[i]-1))
					map.put(nums[i], false);
				else
					map.put(nums[i], true);
				
				if(map.containsKey(nums[i]+1))
					map.put(nums[i]+1, false);
			}

			// ELSE map me yeh key exist krti hai toh --> kuch nhi krege
			
		}
		
//		System.out.println(map.keySet());
		
		int maxLength = 0;
		for(int key : map.keySet())							// sare keys jo jo hai map me aagye
		{
//			System.out.println(map.get(key) +"  "+ map.containsKey(key));
			if(map.get(key))								// kya iss key pe true hai.. agr true hai toh hi yeh start point ho skta
			{
				int count = 0;
				while(map.containsKey(key))				// jb tk key pe value present hai tb tk loop chalo continuous bigger values milrhi hai
				{
					count++;
					key++;
				}
				
				maxLength = Math.max(maxLength, count);
			}
			
			
		}
		return maxLength;
	}
}
