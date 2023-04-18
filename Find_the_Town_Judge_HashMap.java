package hashmap;
import java.util.*;

public class Find_the_Town_Judge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n = 3;
//		int[][] trust = {{1,3},{2,3}};
//		int[][] trust = {{1,3},{2,3},{3,1}};
		int n = 3;
		int[][] trust = {{1,2},{2,3}};
		int ans = findJudge(n, trust);
		System.out.println(ans);
	}
	
	public static int findJudge(int n, int[][] trust)
	{
		if(n==1 && trust.length==0)
			return 1;
		
		HashSet<Integer> set = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			set.add(i);
		}
		
		for (int i = 0; i < trust.length; i++) {
			if(set.contains(trust[i][0]))
				set.remove(trust[i][0]);
		}
		
		if(set.isEmpty())
			return -1;
		

		Iterator key = set.iterator();
		List<Integer> list = new ArrayList<>(set);		// converting or taking the HashSet values in ArrayList to get the values
		while(!list.isEmpty())
		{
			int count_who_knows_me = 0;
			
			for(int[] jnta : trust)
			{
				if(jnta[1]==list.get(0))
					count_who_knows_me++;
			}
			if(count_who_knows_me==n-1)
				return list.remove(0);
			list.remove(0);
		}
		System.out.println("sexy");
		return -1;
	}

}
