package greedy;

import java.util.PriorityQueue;

public class Maximize_Sum_Of_Array_After_K_Negations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,-3,-1,5,-4};
		int k = 2;
		
		int ans = largestSumAfterKNegations(nums, k);
		System.out.print(ans);

	}

	private static int largestSumAfterKNegations(int[] nums, int k) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < nums.length; i++) {
			pq.add(nums[i]);
		}
		
		int ans = 0;
		while(!pq.isEmpty())
		{
			int rem = pq.poll();
			if(k>0)
			{
				rem *= -1;
				pq.add(rem);
				k--;
			}
			else {
				ans = ans+rem;
			}
		}
		
//		System.out.println(pq);
		return ans;
	}

}
