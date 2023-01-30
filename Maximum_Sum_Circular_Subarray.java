package arrays;

public class Maximum_Sum_Circular_Subarray {
	class Solution {
	    public int maxSubarraySumCircular(int[] arr) {
	     int linearSum=kadane(arr);				//max sub array ki sum...
			int max = arr[0];
			int sum=0;
	        int negative_nums = 0;                  // total -ve kitne iska count rkhega
			for (int i = 0; i < arr.length; i++) {
				sum=sum+arr[i];							// pure array ke elements ki sum
	            
	            if(arr[i]<0)                            // agr -ve no mila toh usko count krlo
	                negative_nums++;
	            max = Math.max(max,arr[i]);
				arr[i]=arr[i]*(-1);						// sare element ko invert kro... + ko - and  - ko +
			}
			
			int invertedArraySum= kadane(arr);		// inverted array ki max sum.. means jo part chut gya tha -ve woh 													+ve bnke uski sum..
			
			int circularArraySum = invertedArraySum+sum;		//ab circular ring bnne ke liye inverted -ve part ki 															plus pure array element kis sum jo bnegi circular sum
			
			// agr sare hi nos -ve hai arr[] ke mtlb jo sbse max sum wala [] ka sum no hoga sbse chota -ve num so usiko return krdo
			if(negative_nums==arr.length)           
	        {   // agr -ve nos arr me jitne nos hai utne hai.. means pura array hi -ve hai.. tlb max sum wala [] khud woh num rhega -ve nums mese jo sbse bda -ve num hai
	            return max;
	        }
			return Math.max(linearSum, circularArraySum);
			
		}
		
		
		private static int kadane(int[] arr) {
			// TODO Auto-generated method stub
			int sum=0;
			int maxSum = Integer.MIN_VALUE;
			for (int i = 0; i < arr.length; i++)
			{
				sum=sum+arr[i];
				maxSum=Math.max(maxSum, sum);
				if(sum<0)
					sum=0;
			}
			
			return maxSum;
		}

	}

}
