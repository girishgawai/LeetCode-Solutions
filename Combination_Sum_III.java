package leetcode.coomplex.code;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_III {
	static List<List<Integer>> ansList = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ansList = new ArrayList<>();		// put this bcaz if multiple cases are run.. bcaz of static.. it will takes ur prev ans
//		int k = 3, n = 9;									// so destroying old ans.. by creating fresh list.. else erase/clear list
		int k = 9, n = 45;
		
		formCombinations(k,n,k,n,"",1, new ArrayList<>());
		System.out.println(ansList);
	}

	private static void formCombinations(int k, int n, int range, int sum, String ans, int last, List<Integer> list) {
		// TODO Auto-generated method stub
//		System.out.println(sum+"=="+range+"=="+ans+"=="+last);
		if(range==0 && sum==0)
		{
//			System.out.println(ans);
//			System.out.println(list);
			ansList.add(new ArrayList<>(list));				// ansList.add(new ArrayList<>(list));  <> giving is optional
			return;
		}
		
		if(sum<0)
			return;
		
		for (int i = last; i <= 9; i++) {
//			System.out.println("==");
			list.add(i);
			formCombinations(k, n, range-1, sum-i,ans+i, i+1, list);
			list.remove(list.size()-1);
		}
		
	}

}
