package leetcode.coomplex.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 *   Link - https://www.lintcode.com/problem/178/
 * 
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

Wechat reply 【Google】 get the latest requent Interview questions. (wechat id : jiuzhang1104)


You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example
Example 1:

Input: n = 5 edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
Output: true.
Example 2:

Input: n = 5 edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
Output: false.
 * 
 */

// Ek tree graph valid rhega agr 1. woh cyclic na ho  2. woh connected ho (alg alg nhi) single component
public class Graph_Valid_Tree {
	public static void main(String[] args) {
//		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } }; 
		int n = 5;

		System.out.println(validTree(edges, n));
	}

	private static boolean validTree(int[][] edges, int n) {
		// TODO Auto-generated method stub
		HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new HashMap<>());
		}

		// Map bnane k liye acc to the given edges array[][]
		for (int i = 0; i < edges.length; i++) {
			int v1 = edges[i][0];
			int v2 = edges[i][1];

			map.get(v1).put(v2, 777);  // koi v value daal dege as a cost bcaz sirf array me 2 edges ko connect krti hue vertex btaye hai
			map.get(v1).put(v2, 777);
		}

		return isValidTree(map);
	}

	public static boolean isValidTree(HashMap<Integer, HashMap<Integer, Integer>> map)
	{
		// agr 2 alg alg components diye hoge 2 diff graphs toh  unko traverse krke find krlega phle me nhi toh dusre me graph toh nhi

		HashSet<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();

		int ans = 0;									// this will count number of components i.e graphs
		for(int src : map.keySet())
		{
			// step A - agr visited hai vertex already it means isse path bnaya hai
			if(visited.contains(src))
				continue;

			ans++;								// agr visited nh tha toh uss vertex se v transverse hoga.. 2 component rhege mtlb
			q.add(src);

			while(!q.isEmpty())
			{
				// step 1 - remove
				int remove = q.poll();

				// step 2 - unknown step? check if already visited is being removed..? agr aisa hai toh Cycle hai Graph me
				// cycle detect hue toh ignore kro niche ke steps directly next se continue kro
				if(visited.contains(remove))
				{
					return false;				// it means cycle hai..// agr visited wala wapis aya queue me niklne toh cycle hai graph me
				}

				// step 3 - mark visited
				visited.add(remove);

				// step 4 - self work  --> we have to print the path of traversal
//				System.out.print(remove + " ");

				// step 5 - add univisited neighbours
				for(int nbrs : map.get(remove).keySet())
				{
					if(!visited.contains(nbrs))
						q.add(nbrs);
				}

			}
		}

		return ans==1;				// koi ek se jaada components rhe toh ans++ hote jayega 1 se bda bnega mtlb valid tree nh hai
								// ho skta 2 tree ho dono v cyclic nhin hai.. but components toh 1 nhi hai so invalid tree hai
	}

}
