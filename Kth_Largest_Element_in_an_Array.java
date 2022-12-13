package leetcode.coomplex.code;

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array {
	public static void main(String[] args) {
		
		int[] nums = {3,2,3,1,2,4,5,5,6};
		int k = 4;
		
		int ans = kThLargest(nums, k);
		System.out.println(ans);
	}

	private static int kThLargest(int[] nums, int k) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq = new PriorityQueue<>();		// creating Min Heap
		for (int i = 0; i < k; i++) {
			pq.add(nums[i]);
		}
		
		for(int i = k; i<nums.length; i++)
		{
			if(pq.peek()<nums[i])
			{
				pq.poll();
				pq.add(nums[i]);
			}
		}
		
		return pq.peek();
	}

}
