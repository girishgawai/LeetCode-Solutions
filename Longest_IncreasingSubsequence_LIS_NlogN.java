package leetcode.coomplex.code;

public class Longest_IncreasingSubsequence_LIS_NlogN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int[] arr = {4,10,4,3,8,9};
		
		int LIS_len = LIS(arr);
		System.out.println(LIS_len);
	}

	private static int LIS(int[] arr) {
		// TODO Auto-generated method stub
		int LIS_len = 0;			// length rhegi LIS[] ki
		
		int[] lis = new int[arr.length];				// worst case sare hi elements bnkr LIS bn kste so arr ki size ka lis [] bnaya
		lis[0] = arr[0];			// frst element of arr[] ko lis[] ka frst element bna dia nd size kredeg lis ki 1
		LIS_len = 1;							// ek element add krdia lis me so size uski 1 krdi
		
		for (int i = 1; i < lis.length; i++) {			// kyu ki phla element dekha hai so ab next element se dekhege lis bn skta kya
		// ab endpoint check krege LIS[len] ka mtlb last element agr chota hai arr[i] se toh usjo directly LIS me piche me add krdege size 1 se bdha kr
			if(lis[LIS_len-1]<arr[i])
			{
				lis[LIS_len] = arr[i];					// mtlb woh lis ka part bn skta hai
				LIS_len++;
			}
			else
			{	// agr lis[len]>arr[i] endpoint bda hai.. toh lis[] ke array me exact correct posn dhundo arr[i] k liye fir usko replace krdo
				int replaceLoc = search(lis, 0, LIS_len-1, arr[i]);
				lis[replaceLoc] = arr[i];
			}
		}

		for (int i = 0; i < lis.length; i++) {
			System.out.print(lis[i] + "   ");
		}
		System.out.println();
		return LIS_len;
	}

	// Kyu ki Longest Increasing Order maintain hora hai lis[] me so array ka data sorted hi hhoga.. isliye Search krne Binary Search use kre
	private static int search(int[] lis, int si, int ei, int item) {
		// TODO Auto-generated method stub
		int idx = 0;
		
		while(si<=ei)
		{
			int mid = (si+ei)/2;
			if(item<=lis[mid])					// yha pe agr choti val hai usse so isse v choti kha oe mil skti hai
			{
				idx = mid;
				ei = mid-1;
			}
			else
			{
				si = mid+1;
			}
		}
		
		return idx;
	}

}
