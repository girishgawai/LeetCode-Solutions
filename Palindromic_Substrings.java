package axis_orbit_technique_palindrome_substring;

import java.util.Iterator;
import java.util.Scanner;

public class Palindromic_Substrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int countPalindromicSubstring = checkPalindromicSubstring(str);
		System.out.println(countPalindromicSubstring);
	}

	private static int checkPalindromicSubstring(String str) {
		// TODO Auto-generated method stub
		int count = 0;
		
		// for odd length of String
		for (int axis = 0; axis < str.length(); axis++) {
			for (int orbit = 0; orbit < str.length() && (axis-orbit)>=0 && (axis+orbit)<str.length(); orbit++) {
				if(str.charAt(axis-orbit)!=str.charAt(axis+orbit))
					break;
				count++;
//				System.out.println(str.substring(axis-orbit,axis-orbit+1));
			}
		}
		
		// for even length of String			-- >    even ke liye axis ko bich se chalao letters ke 0.5 and orbit ko v same then +1
		for (double axis = 0.5; axis < str.length(); axis++) {
			for (double orbit = 0.5; orbit < str.length() && (axis-orbit)>=0 && (axis+orbit)<str.length(); orbit++) {
				if(str.charAt((int)(axis-orbit))!=str.charAt((int)(axis+orbit)))			// index point me nhi rhte so typecast to int
					break;
				count++;
			}
		}
		
		return count;
	}

}
