package leetcode.coomplex.code;

import java.util.HashMap;
import java.util.Stack;

public class Next_Greater_Element_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {4,1,2};
		int[] nums2 = {1,3,4,2};

		int[] ans = nextGreaterElement(nums1, nums2);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i]+" ");
		}

	}

	private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		// TODO Auto-generated method stub
		int[] sol = new int[nums1.length];
		HashMap<Integer, Integer> map = new HashMap<>();
		Stack<Integer> st = new Stack<>();

		st.push(0);
		for(int i = 1;i<nums2.length;i++)
		{
			while(!st.isEmpty() && nums2[st.peek()]<nums2[i])
			{
				int item = st.pop();
//				sol[item] = nums2[i];
				map.put(nums2[item], nums2[i]);
			}

			st.push(i);
		}
		
		while(!st.isEmpty())
		{
			int item = st.pop();
//			sol[item] = -1;
			map.put(nums2[item], -1);
		}
		
		for (int i = 0; i < nums1.length; i++) {
			if(map.containsKey(nums1[i]))
			{
				sol[i] = map.get(nums1[i]);
			}
		}
		return sol;
	}

}
