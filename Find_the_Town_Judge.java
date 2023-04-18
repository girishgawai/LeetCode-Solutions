package graph;
import java.util.*;

public class Find_the_Town_Judge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
//		int[][] trust = {{1,3},{2,3}};
		int[][] trust = {{1,3},{2,3},{3,1}};
//		int n = 3;
//		int[][] trust = {{1,2},{2,3}};
		int ans = findJudge(n, trust);
		System.out.println(ans);
	}
	
	public static int findJudge(int n, int[][] trust)
	{
		if(n==1 && trust.length==0)
			return 1;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			map.put(i, 0);
		}
		
		HashSet<Integer> commonman = new HashSet<>();
		for (int i = 0; i < trust.length; i++) {
			map.put(trust[i][1], map.get(trust[i][1])+1);
			commonman.add(trust[i][0]);
		}
//		List<Integer> ass = new ArrayList<>(commonman);
//		System.out.println(ass);
		for(int key : map.keySet())
		{
//			System.out.println(map.get(key)+"==> "+key+" <== ");
			if(map.get(key)==n-1)
			{
				if(!commonman.contains(key))
					return key;
			}
		}
		
		return -1;
	}

}
