package leetcode.coomplex.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class IntersectionofTwoArrays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();

		int[] nums1 = new int[n1];
		int[] nums2 = new int[n2];
		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = sc.nextInt();
		}
		for (int i = 0; i < nums2.length; i++) {
			nums2[i] = sc.nextInt();
		}

		int[] ans = intersection(nums1, nums2);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}
	

	public static int[] intersection(int[] nums1, int[] nums2) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			if(!map.containsKey(nums1[i]))
				map.put(nums1[i], true);
		}
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums2.length; i++) {
			if(map.containsKey(nums2[i]) && map.get(nums2[i])==true)
			{
				map.put(nums2[i], false);
				list.add(nums2[i]);
			}
		}
		
		int[] ans =  new int[list.size()];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = list.get(i);
		}
		return ans;
	}
}
