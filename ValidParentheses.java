package leetcode.coomplex.code;

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		ValidParentheses vp = new ValidParentheses();
		boolean ans = vp.isValid(str);
		System.out.println(ans);
	}

	public boolean isValid(String str) {
		String sqb = "[]";
		String rb = "()";
		String cb = "{}";
		
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			if('('==str.charAt(i) || '['==str.charAt(i) || '{'==str.charAt(i))
			{
				st.push(str.charAt(i));
			}
			else
			{
				if(st.isEmpty())
					return false;
				char ch = str.charAt(i);
				Character pop = st.pop();
				boolean status = (sqb.contains(ch+"") && sqb.contains(pop+"")) || (rb.contains(ch+"") && rb.contains(pop+"")) || (cb.contains(ch+"") && cb.contains(pop+""));
				if(status==false)
				{
					return false;
				}
			}
		}
		if(str.length()%2!=0)
			return false;
		
		if(!st.isEmpty())
			return false;
		
		return true;
	}
}
