package leetcode.coomplex.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Is_Graph_Bipartite {		// Odd len Cycle nhi honi chahiye  // Even len Cycle may not or maybe Bipartite  
																				// vtx adjnct not to be in same set(accross set chahiye)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };

		System.out.println(isBipartite(graph));
	}

	public static boolean isBipartite(int[][] graph) {

		HashMap<Integer, Integer> visited = new HashMap<>();
		Queue<Pair> q = new LinkedList<>();


		for(int src=0; src<graph.length; src++)
		{
			// step A - agr visited hai vertex already it means isse path bnaya hai.. toh chod do iss ko aage wale pe jao =
			if(visited.containsKey(src))
				continue;


			q.add(new Pair(src, 0));

			while(!q.isEmpty())
			{
				// step 1 - remove
				Pair remove = q.poll();

				// step 2 - unknown step? check if already visited is being removed..? agr aisa hai toh Cycle hai Graph me
				// cycle detect hue toh ignore kro niche ke steps directly next se continue kro
				if(visited.containsKey(remove.vtx))		// it means cycle hai..// agr visited wala wapis aya queue me niklne toh cycle hai graph
				{
					if(remove.lv!=visited.get(remove.vtx))		// odd len ki cycle hai mtlb hai Bipartite nhi hai
					{					// removePair wala vtx ka level agr same nh hai visited ke removed wale vertex ki level jitna
						return false;				// 3  2  --> toh odd len ki cycle hai
					}
					else					// agr cycle hai bt rmv pair vtx level & visited ke removed vtx ki level same hai
					{									// mtlb even len cycle hai.. toh bipartitie RHE skta Maybe.. aage ka check kro
						continue;										// continue krke next element se Q ke
					}
				}

				// step 3 - mark visited
				visited.put(remove.vtx, remove.lv);		// visited mark krdo jis level se nikala aur jis vertex ko nikala Pair me

				// step 4 - self work  --> we have to print the path of traversal
//				System.out.print(remove + " ");

				// step 5 - add unvisited neighbours	// ADD krte time uss neighbour ko kiss level se ADD kia woh level daalo
				for(int nbrs : graph[remove.vtx])				// removed(VTX) level ki next level --> add hue hai
				{
					if(!visited.containsKey(nbrs))
						q.add(new Pair(nbrs, remove.lv+1));			// removed vtx ki next level ke neighbours add hoge so +1 krke add kro
				}
			}

		}

		return true;
	}

	public static class Pair {
		int lv, vtx;						// jiss level se add kr rhe uss level ki value // vertex -->

		public Pair(int vt, int lv)
		{
			this.vtx = vt;
			this.lv = lv;
		}
	}
}
