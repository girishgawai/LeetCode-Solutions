package leetcode.coomplex.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Palindrome_Partitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		String str= "nitin";
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		List<String> list = new ArrayList<>();						// for string the ans of String in LIST

		List<List<String>> ans = new ArrayList<>();					// for storing the ans List into another List

		formPartition(str,"",list,ans);
		System.out.println(ans);
	}

	private static void formPartition(String que, String ans, List<String> list, List<List<String>> finalAns) {
		// TODO Auto-generated method stub
		if(que.length()==0)
		{
			//			System.out.println(ans);
			//			System.out.println(list);
			
//			finalAns.add(list);			// this will store empty List into List because same list is getting added due to same address
															// same list having elements is added then removed as well  thats why
			
			finalAns.add(new ArrayList<>(list));		// So created a new ArrayList which will always have diff new address and stored the 
																// ans list value into it and then from it added to finalAns List
			return;
		}

		for (int i = 1; i <= que.length(); i++) 
		{
			String s = que.substring(0,i);
			list.add(s);
			if(isPalindrome(s)==true)
				formPartition(que.substring(i), ans+"|"+s, list, finalAns);
			list.remove(list.size()-1);							// BackTracking because recursion can't undo remove string which is added 
			// into it for that particular call
		}

	}

	private static boolean isPalindrome(String s) {
		// TODO Auto-generated method stub
		for (int i = 0, j=s.length()-1; i<j; i++, j--) {
			if(s.charAt(i)!=s.charAt(j))
				return false;
		}
		return true;
	}

}
