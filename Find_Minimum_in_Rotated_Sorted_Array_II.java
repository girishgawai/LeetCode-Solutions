package arrays;

public class Find_Minimum_in_Rotated_Sorted_Array_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,3,5};			// 2,2,2,0,1			// 1,1
		
		int min = findMin(arr);
		System.out.println(arr[min]);
		
		System.out.println(findMin_2Pointer(arr));
	}

	// via Binary Search Algorithm
	public static int findMin(int[] nums) {
        int si = 0;
        int ei = nums.length-1;
        
        while(si<ei)
        {
        	int mid = (si+ei)/2;
        	if(nums[mid]>nums[ei])				// it means mid wale posn se aage hi hai khi toh v smallest num
        		si = mid+1;
        	else if(nums[mid]>nums[si])			// agr mid wala si se bda hai means mid ke phle hi hoga min num at somewhere
        		ei = mid;
        	else								// agr mid wala == hai ei ke means mid se ei ke bich hai.. toh ei ko ek se - minus kro
        		ei--;
        }
        
        return si;
    }
	
	// via 2 - Pointer approach
		public static int findMin_2Pointer(int[] nums) {
	        int start = 0;
	        int end = nums.length-1;
	        int min = Integer.MAX_VALUE;
	        
	        while(start<=end)
	        {
	        	min = Math.min(Math.min(nums[start], nums[end]), min);
	        	start++;
	        	end--;
	        }
	        
	        return min;
	    }
		
		// via Sort the Array and return the first element which will be the minimum num
}
