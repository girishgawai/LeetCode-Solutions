package arrays;

public class Global_and_Local_Inversions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,0,2};
		
		System.out.println(isIdealPermutation(nums));
	}
	
	// Optimized Greedy Way
	public static boolean isIdealPermutation(int[] nums) {
		// as every local inversion is also global inversion.. so if we found any global inversion which is not local then it will
		// be an extra global inversion so we can say false return
		
		int curr_max = Integer.MIN_VALUE;		// current max store rkhega curr ith index tk ka
		for (int i = 0; i < nums.length-2; i++) {		// kyu ki global inversion ko i+2 tk check kr rhe hai so out of bound na jaye isliye
			curr_max = Math.max(curr_max, nums[i]);
			
			if(curr_max>nums[i+2])		// agr av tk ka curr_max, next local arr[i+2] se bda ho gya.. mtlb ek global inversion mila jo local inversion nh hoga
				return false;				// mtlb extra global inversion mila.. means local!=global inversion
		}
		
		return true;
	}

	// Gives TLE
	public static boolean isIdealPermutation_TLE(int[] nums) {
		int global = 0;
		int local = 0;
		
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i]>nums[i+1])
				local++;
		}
		
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = i; j < nums.length; j++) {
				if(nums[i]>nums[j])
					global++;
			}
		}
		
		return local==global;
	}
}
