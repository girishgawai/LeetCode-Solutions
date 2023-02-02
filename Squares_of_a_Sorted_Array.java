package arrays;

public class Squares_of_a_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-4,-1,0,3,10};

		int[] ans = sortedSquares(nums);
		for(int i=0; i<nums.length;i++)
		{
			System.out.print(ans[i] + " ");
		}
	}

	public static int[] sortedSquares(int[] nums) {
		// kyu ki arr sorted hai toh sbse bda wala end me hoga data nd sbse chota start me.. bt agr num -ve hai start wala chota
		// uska square bda rhe skta jo last me aaskta
		// so ek placing index manage krge jo bde squares hoge unko piche me add krege
		int start = 0;
		int end = nums.length-1;
		int[] result = new int[nums.length];
		for (int max_placer = nums.length-1; max_placer >= 0; max_placer--) {	// piche me dalege bda wale ko placer_index pe
			if(Math.abs(nums[start]) > Math.abs(nums[end]))
			{
				result[max_placer] = nums[start]*nums[start];
				start++;
			}
			else
			{
				result[max_placer] = nums[end]*nums[end];
				end--;
			}
		}
		
		return result;
	}
}
