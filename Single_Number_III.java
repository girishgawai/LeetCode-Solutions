package leetcode.coomplex.code;

public class Single_Number_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,1,3,2,5};
		
		int[] ans = singleNumber(arr);
		for (int i = 0; i < ans.length; i++) {			
			System.out.print(ans[i] +"  ");
		}
	}

	private static int[] singleNumber(int[] arr) {
		// TODO Auto-generated method stub
		int xorOp = 0;
		for (int i = 0; i < arr.length; i++) {
			xorOp ^= arr[i];
		}
		// now xorOp will contains the data which is xor of both the 2 Single occurrence nos -> so for separating them
		
		int mask = xorOp & (~(xorOp-1));	// if xorOp = 10010100 --> xorOP-1= 10010011  --> negation of it --> 01101100
//				this gives the loc from where both the single nos bits are diff					   			  &	 10010100 => 00000100
//		will now Bitwise ANS this mask data wid every element from arr.clone(). grouping them wid in 2 parts..arr rem 1&0 then from the 
//		remain that if its 0 will take singleno1 xor with those arr element then finally find 2nd single no
		int single_no1 = 0;
		for (int i = 0; i < arr.length; i++) {
			if((mask & arr[i]) != 0)
				single_no1 = single_no1 ^ arr[i];
		}
		
	// now from 1st single no we can find the second single no --> buy taking XOR of 1st single no with xorOp val which is xor of both
		int single_no2 = xorOp ^ single_no1;						// singleno1 XOR will cut its own value and gives single no2
		return new int[] {single_no1, single_no2};
	}

}
