import java.util.HashSet;
import java.util.PriorityQueue;

public class Third_Maximum_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1};
		
		System.out.println(thirdMax(nums));
		
	}
	
	
	public static int thirdMax(int[] nums) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		HashSet<Integer> visited = new HashSet<>();
		int limit = 3;
		for (int i = 0; i < limit && i < nums.length; i++) {					// max 3 elements ka PQ bnana hai
			if(!visited.contains(nums[i]))			// agr elements repeated aaye starting me hi toh 3 se cum hi elements add hoge PQ me
			{							// isliye i<limit ke sath sathi array ki len v li.. khi aise na ho limit bdhi hue k chkkr me jitne elements nhi utne idx pe 'i' chle jaye
				visited.add(nums[i]);
				pq.add(nums[i]);
			}
			else
				limit++;							// agr visited wala element hai PQ meka.. toh limit bdhao uski 3 se.. means utne nums skip hue fir v atleast 3 nos add hoge PQ mein
		}
//		System.out.println(pq);
		for (int i = limit; i < nums.length; i++) {
			if(!visited.contains(nums[i]))
			{
				visited.add(nums[i]);				// ab unvisited/uniq elements add krege PQ me.. 
				pq.add(nums[i]);						
											
				pq.poll();							// aur add krne k sath ek elment remove krege jo sbse chota rhega
			}
		}
		
		if(pq.size()==2)					// agr PQ me 3 se cum elements hai.. means given[] hi chota tha.. toh agr 2 nos bche hai PQ me
		{							// means usme se usme se jo sbse bda hai usko bhejna hai.. 
			pq.remove();								// isliye ek element remove kia toh ab ek hi no bcha PQ me.. sbse bda wala
		}
		return pq.poll();							// sbse bde wale ko nikal kr bheje
	}

}
