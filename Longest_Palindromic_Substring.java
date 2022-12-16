package leetcode.coomplex.code;
import java.util.Scanner;

public class Longest_Palindromic_Substring {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		String countPalindromicSubstring = checkPalindromicSubstring(str);
		System.out.println(countPalindromicSubstring);
	}

	private static String checkPalindromicSubstring(String str) {
		// TODO Auto-generated method stub
		
		int count = 0;
		String ans = new String();
		int max = 0;
		int orbit = 0;
		// for odd length of String
		for (int axis = 0; axis < str.length(); axis++) {
			count = 0;
			for (orbit = 0; orbit < str.length() && (axis-orbit)>=0 && (axis+orbit)<str.length(); orbit++) {
				if(str.charAt(axis-orbit)!=str.charAt(axis+orbit))
					break;
				count++;
				//				System.out.println(str.substring(axis-orbit,axis-orbit+1));
			}
			if(max<count)
			{
				max = count;
				ans = str.substring(axis-orbit+1, axis+orbit);
			}
		}
//		System.out.println(ans+"ju");
		
		// for even length of String			-- >    even ke liye axis ko bich se chalao letters ke 0.5 and orbit ko v same then +1
		String ans1 = new String();
		int max1 = 0;
		double orbit11 = 0.5;
		for (double axis = 0.5; axis < str.length(); axis++) {
			count = 0;
			for ( orbit11 = 0.5; orbit11 < str.length() && (axis-orbit11)>=0 && (axis+orbit11)<str.length(); orbit11++) {
				if(str.charAt((int)(axis-orbit11))!=str.charAt((int)(axis+orbit11)))			// index point me nhi rhte so typecast to int
					break;
				count++;
			}
			if(max1<count)
			{
				max1 = count;
				ans1 = str.substring((int)(axis-orbit11+1), (int)(axis+orbit11));
			}
		}

//		System.out.println(ans);
//		System.out.println(ans1);
		if(ans1.length()>ans.length())
			return ans1;
		return ans;
	}

}
