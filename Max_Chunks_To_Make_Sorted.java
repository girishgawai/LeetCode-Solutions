package arrays;

public class Max_Chunks_To_Make_Sorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,0,2,3,4};						//{4,3,2,1,0};

		System.out.println(maxChunksToSorted(arr));
	}

	public static int maxChunksToSorted(int[] arr) {
		int max = 0;				// jo max bnte jayega uska track rkhega
		int partition = 0;
		for (int i = 0; i < arr.length; i++) {					// iterate krege array me hr posn se.. aur curr max dekhege
			max = Math.max(arr[i], max);									// jha pe curr max usske indx tk jayega wha tk note krege.. usko cross krne kee baad
			if(i==max)											// agr max == same idx uski limit tk aya means ek partition bnega wha
				partition++;
		}

		return partition;
	}
}
