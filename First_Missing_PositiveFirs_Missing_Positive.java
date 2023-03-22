package arrays;

public class First_Missing_PositiveFirs_Missing_Positive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-1,4,2,1,9,10};
		System.out.println(firstMissingPositive(arr));
	}

	public static int firstMissingPositive(int[] nums)
	{
		for (int i = 0; i < nums.length; i++) 		// loop me traverse kro.. hr index pe.. nd jha v -ve num mile wha se usko uthakr
		{														// uske correct posnt pe rkho(arr[i]=2-> i-1th posn pe rkho 2 ko)
			if(nums[i]>0 && nums[i]<=nums.length)
			{
				int data = nums[i];
				if(data!=nums[data-1])
				{
					nums[i] = nums[data-1];
					nums[data-1] = data;
					
					i--;					// agr manlo swap hua hai toh curr pe aya hua correct posn pe hai ya nhi? garranty nh na.. toh usi posn(cur) wale
											// num ko dobara check krege uski exact posn pe rkhne ka	--> isliye same posn wale num ko waps check krne k liye i-- kia kyu ki for loop me auto incrementation hoga		
				}
				else
				{
					// agr dono element same hai both loc ke toh kuch v nhi krna hai.. next element pe jayege agla data check krne
				}
			}
//			System.out.println(nums[i]+"="+i);
		}

		for (int i = 0; i < nums.length; i++) {

			if(i+1!=nums[i])
				return i+1;				// agr uss posn ka data posn se match nhi krta.. mtlb woh posn hi ans hai-> missing data
		}


		return nums.length+1;	// agr ek hi element hoga qstn[] me & woh v 1 hoga ya 1 se bda hoga ya fir 0 or usse chota.. it means uski posn nh hoga valid [] me
	}											// toh hm array ki length +1 return krege +ve missing number krke
}
