package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public class Non_overlapping_Intervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] interval = {{1,2},{2,3},{3,4},{1,3}};

		System.out.println(eraseOverlapIntervals(interval));
	}

	public static int eraseOverlapIntervals(int[][] intervals) {
		
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] a , int[] b)
			{
				return a[0]-b[0];
			}
		});
		
		LinkedList<int[]> res = new LinkedList<>();		// resultant list rhegi ye.. non overlapping arrays ki
		res.add(intervals[0]);								// phla wala array[] add krdiya list me
		
		for (int i = 1; i < intervals.length; i++) 
		{
			// ab compare krege curr wale[] & prev array ko.. over lap hai ya nh hai
			int[] prev = res.getLast();					// resulatant list me ka valid wala prev array
			int[] curr = intervals[i];						// current array me ka array
			
			
			// agr curr [] ka start posn < prev [] ka end posn se means over lap hai
			if(curr[0]<prev[1])
			{
				// means overlapping hori hai  --> it means hme resultant list me ka last array remove krna pdega and nya array add krna hoga
				// nya array jo add hoga woh uska start pos whi rhega resultant list me ka jo prev [] tha whi, Lekin end pos ko replace krege 
				// Minimum number se end posn ke Min(prev,curr) [] ke
				prev[1] = Math.min(prev[1], curr[1]);
				
				// removing already existing last array[] from resultant list kyu ki woh overlap krjara hai curr arr[] ke sath
				res.removeLast();
				
				// resultant list me add kredge whi updated array[] prev wala jo ab overlap kia tha  uska modified minimum end wala add kro
				res.addLast(prev);
			}
			else
			{			// agr koi v array[] overlap nhi hora.. toh simply usko resultant list me add krdo
				res.add(curr);
			}
		}
		
		// ab original array intervals kis size - resultant list ki size krege toh diff mil jayega ki kitna arr[] bche hue hai jo overlap nhi hote
		return intervals.length-res.size();
	}
}
