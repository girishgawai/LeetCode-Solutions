package recurssion;
import java.util.*;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4, k = 2;

        combinations = new ArrayList();
        
		combine(1,n,k,"", new ArrayList<Integer>());
		System.out.println(combinations);
	}

	static List<List<Integer>> combinations = new ArrayList<>();
	private static void combine(int curr, int n, int k, String ans, List<Integer> list) {
		// TODO Auto-generated method stub
		if(list.size()==k)
		{
			combinations.add(new ArrayList<>(list));
//			System.out.println(ans);
			return;
		}
		
		
		for (int i = curr; i <= n; i++) {
			list.add(i);
			combine(i+1, n, k, ans+i, list);
			list.remove(list.size()-1);									// back-tracking
		}
		
	}

}
