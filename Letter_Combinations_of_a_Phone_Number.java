package leetcode.coomplex.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Letter_Combinations_of_a_Phone_Number {

	static String[] key = {"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String digits= sc.next();

		List<String> list = new ArrayList<String>();
		if(digits.length()==0)
			System.out.println(list);

		list = pressKey(digits, "", new ArrayList<String>());

		System.out.println(list);
	}

	private static List<String> pressKey(String digits, String ans, ArrayList<String> list) {
		// TODO Auto-generated method stub
		if(digits.length()==0)
		{
			//			System.out.println(ans+"  ");
			list.add(ans);
			return list;
		}

		char num = digits.charAt(0);
		String letters = key[num-'0'];
		//		System.out.println(letters);

		for (int i = 0; i < letters.length(); i++) {
			pressKey(digits.substring(1), ans+letters.charAt(i), list);
		}
		return list;

	}

}
