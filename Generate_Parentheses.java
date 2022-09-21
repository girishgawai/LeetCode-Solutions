package leetcode.coomplex.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Generate_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int pair=sc.nextInt();
		
		List<String> list = new ArrayList<>();
		
		printPerfectParenthesis(pair,0,0,"",list);				//pair-size..open brace..closing brace..ans
		System.out.println(list);

	}

	private static void printPerfectParenthesis(int pair, int open, int close, String ans, List<String> list) {
		// TODO Auto-generated method stub
		if(open==pair && close==pair)
		{
//			System.out.println(ans);
			list.add(ans);
			return;
		}
		
//		if(close>open)				//optional
//			return;
		
		if(open<pair)
		{
			printPerfectParenthesis(pair, open+1, close, ans+"(", list);
		}
		if(close<open)
		{
			printPerfectParenthesis(pair, open, close+1, ans+")",list);
		}
		
	}

}
