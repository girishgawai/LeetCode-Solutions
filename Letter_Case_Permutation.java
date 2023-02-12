package recurssion;

import java.util.*;

public class Letter_Case_Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a1b2";
		letterCasePermutation(s);
	}

	public static List<String> letterCasePermutation(String s) {
		List<String> list = new ArrayList<>();
		letterpermut(s,0,"",list);
		return list;
	}

	private static void letterpermut(String s, int i, String ans, List<String> list) {
		// TODO Auto-generated method stub
		if(i==s.length())
		{
			list.add(ans);
			System.out.println(ans);
			return;
		}

		if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
			letterpermut(s, i+1, ans+s.charAt(i), list);
			return;
		}
		letterpermut(s, i+1, ans+(s.charAt(i)+"").toUpperCase(), list);
		letterpermut(s, i+1, ans+(s.charAt(i)+"").toLowerCase(), list);
	}

}
