package stacks;

import java.util.Stack;

public class Maximal_Rectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		
		int maxArea = 0;
		int[] height = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j]=='1')					// agr curr loc pe 1 hai toh upr me ki ht se +1 krdege khudki ht add krne k liye
					height[j] = ++height[j];
				else
					height[j] = 0;			// agr curr loc pe 0 hai toh upr me ki ht ko relax krdege 0 pe
			}
			
//			for (int j = 0; j < height.length; j++) {
//				System.out.print(height[j]);
//			}
//			System.out.println();
			maxArea = Math.max(maxArea, maximalRectangle(height));				// har row se heights wala [] se historgram ko call krege
		}																				// max area of rectangle ke liye
		System.out.println(maxArea);
	}

	public static int maximalRectangle(int[] histogram) {			// Histogram wala arr bheja heights ka
		int area = 0;
		Stack<Integer> st = new Stack<>();					// stack will hold the left side minimum than present
		
		for (int i = 0; i < histogram.length; i++) {
			while(!st.isEmpty() && histogram[i]<histogram[st.peek()])	// stack ke top wale data se nya ane wala building agr choti rhi toh
			{
				int R = i;							// rt side wali building jo rt min bn skti hai top wale data/building ki
				int H = histogram[st.pop()];					// stack ka toop nikala means woh building jiska Rt min mila jo ara hai
				
				if(!st.isEmpty())
				{					// agr stack khali nhi hua pop krke top ki data/ht ko toh left min v stack me hai available
					int L = st.peek();
					area = Math.max(area, (R-L-1)*H);
				}
				else
					area = Math.max(area, R*H);					// agr pop krne se top ka data stack khali ho gya means left min nhi hai iska koi
			}															// sirf rt min hi hai nd uski khudki ht
			st.push(i);
		}
		
		// agr stack me fir v elements bche hai.. means woh compare nh hue.. usna rt min nhi hai koi v .. stack me bs left mins hi hai
		// toh right side min assume krege 0 ht ki array ki length wala index hai krke
		int R = histogram.length;					// len hi array ki rt min bnega
		while(!st.isEmpty())
		{
			int H = histogram[st.pop()];								// building ki ht
			if(!st.isEmpty())
			{
				int L = st.peek();
				area = Math.max(area, (R-L-1)*H);
			}
			else
				area = Math.max(area, R*H);
		}
		
		return area;
	}
}
