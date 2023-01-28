package arrays;

public class Remove_Duplicates_from_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		
		int ans = removeDuplicates(nums);
		System.out.println(ans + "######");
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i] + " ");
		}
	}

	private static int removeDuplicates(int[] nums) {
		// TODO Auto-generated method stub
		int item = nums[0];							// first element array ka note down krlia
		
		// ab compare krte jayege item ko current idx wale element se
		int replace_idx = 1;					// agr koi element ko replace krna rha duplicate aane pe toh jis idx pe rkhna uska track rkhega ye
		
		int count = 1;				// counts the len of perfect individual [].. initiall ek element ko differ mankr count 1 rkh re
		for (int i = 1; i < nums.length; i++) {
			if(item==nums[i])
			{
				// toh kuch nhi krege bss curr index ko aage bdha kr next idx wala element check krege item ke sath
			}
			else
			{		// agr dono item nd cur wala elemtn alg hai means usko replace or correct loc oe bhejo.. ie. usko replace wale loc pe
				nums[replace_idx] = nums[i];
				// aur uss replace idx ko aage bdho ek se.. emans next correct loc agr diff element aya toh yha aakr baithega
				replace_idx++;
				item = nums[i];					// aur item ko v update krdo.. av jisse replace kia wohi item bnega fresh alg element
				count++;						// jb v valid diff no mila usko correct loc placed krke len count kr rhe .. +1 kr rhe new [] ka
			}
		}
		
		return count;
	}

}
