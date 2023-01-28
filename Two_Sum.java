package arrays;

public class Two_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,7,11,15};
		int target = 9;
		
		int[] ans = twoSum(nums,target);
		System.out.println(ans[0] + " , " + ans[1]);
	}

	private static int[] twoSum(int[] nums, int target) {
		// TODO Auto-generated method stub
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1+i; j < nums.length; j++) {
				if(nums[i]+nums[j]==target)
					return new int[] {i,j};
			}
		}
		
		
		return null;
	}

}
