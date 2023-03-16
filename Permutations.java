package leetcode.coomplex.code;
import java.util.*;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3};
		permute(arr);
	}

	static List<List<Integer>> list = new ArrayList<>();
	public static List<List<Integer>> permute(int[] nums) {
		
		list = new ArrayList<>();													// for leetcode multiple backend test cases
		
		boolean[] visited = new boolean[nums.length];
		permutations(nums, 0, "", visited, new ArrayList<>());
		System.out.println(list);
		return list;
	}

	public static void permutations(int[] nums, int curr, String ans, boolean[] visited, List<Integer> sol) {

		if(sol.size()==nums.length)
		{

				list.add(new ArrayList<>(sol));
//				System.out.println(ans);
//				System.out.println(sol);

			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if(visited[i]==false)
			{
				visited[i] = true;
				sol.add(nums[i]);
				permutations(nums, i+1, ans+nums[i], visited, sol);
				sol.remove(sol.size()-1);										// back-tracking --> firse remove krdo add kiye hue element ko
				visited[i] = false;												// back-tracking --> firse unvisited mark krdo 
			}				
		}
	}
	
	
	/*		HashSet used as a visited tracker
	 * static List<List<Integer>> list = new ArrayList<>();
	public static List<List<Integer>> permute(int[] nums) {
		
		list = new ArrayList<>();													// for leetcode multiple backend test cases
		
		boolean[] visited = new boolean[nums.length];
		HashSet<Integer> marked = new HashSet<>();
		permutations(nums, 0, "", marked, new ArrayList<>());
		System.out.println(list);
		return list;
	}

	public static void permutations(int[] nums, int curr, String ans, 		HashSet<Integer> marked, List<Integer> sol) {

		if(sol.size()==nums.length)
		{

				list.add(new ArrayList<>(sol));
//				System.out.println(ans);
//				System.out.println(sol);

			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if(marked.contains(nums[i])==false)
			{
				marked.add(nums[i]);
				sol.add(nums[i]);
				permutations(nums, i+1, ans+nums[i], marked, sol);
				sol.remove(sol.size()-1);										// back-tracking --> firse remove krdo add kiye hue element ko
				marked.remove(nums[i]);											// back-tracking --> firse unvisited mark krdo 
			}
		}
	}
	
	*/
}
