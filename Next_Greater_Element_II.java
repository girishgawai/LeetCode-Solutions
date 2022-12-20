package leetcode.coomplex.code;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Next_Greater_Element_II {			// CIRCULAR ARRAY PROBLEM
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		int[] ans = new int[n];
		Arrays.fill(ans, -1);
		findGreater(arr,ans);
		
		
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i]+ " ");
		}
	}

	private static int[] findGreater(int[] arr, int[] ans) {
		// TODO Auto-generated method stub
		Stack<Integer> st = new Stack<>();
		
		for (int i = 0; i < 2*arr.length; i++) 				// due to checking for cicular array
		{
			while(!st.isEmpty() && arr[i%arr.length]>arr[st.peek()])
			{
				ans[st.pop()]= arr[i%arr.length];
			}
			st.push(i%arr.length);
		}

        return ans;
	}

}
