package stack_qps;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 5, 4, 6, 1, 7 };
		System.out.println(largestRectangleArea(arr));

	}

	private static int largestRectangleArea(int[] arr) {
		// TODO Auto-generated method stub
		Stack<Integer> st = new Stack<>();
		int ans = 0;
		for (int i = 0; i < arr.length; i++) 
		{
			while(!st.isEmpty() && arr[i]<arr[st.peek()])
			{
				int r = i;				// right minimum of stacke top wala element ka
				int h = arr[st.pop()];			// ht nikal li stack ke top wale index ki element value.. pop krke stack ke top ko

				if(!st.isEmpty())
				{
					int l = st.peek();				// stack ke top wale index element ki value jo peek rhegi.. left minimum ht
					ans = Math.max(ans, (r-l-1)*h);			// agr stack empty nhi hua toh aise calculate krege area.. l*b
				}
				else
				{
					ans = Math.max(ans, r*h);		// agr stack khali/empty ho gya toh.. aise calculate krege area.. left min nhi hoga
				}
				
			}

			st.push(i);
		}

		int r = arr.length;			// rt min

		while(!st.isEmpty())
		{
			int h = arr[st.pop()];
			if(!st.isEmpty())
			{
				int l = st.peek();
				ans = Math.max(ans, (r-l-1)*h);
			}
			else
				ans = Math.max(ans, r*h);
		}

		return ans;
	}

}
