package stack_qps;

import java.util.Stack;

public class The_Celebrity {

	// https://www.geeksforgeeks.org/the-celebrity-problem/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 0, 1, 1, 1 }, { 1, 0, 1, 1 }, { 0, 0, 0, 0 }, { 1, 1, 1, 0 } };
		System.out.println(Celebrity(arr));
	}

	private static int Celebrity(int[][] arr) {
		// TODO Auto-generated method stub
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			st.push(i);
		}
		
		while(st.size()>1)			// jb tk stack me sirf ek hi data na bche chlte jao
		{
			int a = st.pop();
			int b= st.pop();
			
			if(arr[a][b]==1)
				st.push(b);
			else
				st.push(a);
			
		}
		
		int celebrity = st.pop();			// bcha hua ek single akhri data v stack me ka nikal diya aur ss var me store kia jo bol
														// rha hai ki celeb ho sktaq hai
		
		for (int i = 0; i < arr.length; i++) {
			if(i!=celebrity && (arr[celebrity][i]==1 || arr[i][celebrity]==0))
					return -1;					// ya toh celeb janta hai kisi ko OR celeb ko koi nhi janta AND celeb & khuska index 
														// same na ho
		}
		
		return celebrity;		// isko sab jante but ye kisi ko nhi janta.. ==? celeb hai tu
	}

}
