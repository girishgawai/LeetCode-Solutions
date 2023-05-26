package stacks;

import java.util.Stack;

public class MinimumAddtoMakeParenthesesValid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "()))((";
		System.out.println(minAddToMakeValid(s));
	}

	private static int minAddToMakeValid(String s) {
		// TODO Auto-generated method stub
		Stack<Character> st = new Stack<>();
		
		for(int i=0; i<s.length(); i++)
		{
			char ch = s.charAt(i);
			if(!st.isEmpty() && st.peek()=='(' && ch==')')
				st.pop();
			else
				st.push(ch);
		}
		
		return st.size();
	}

	private static int WRONG_CODE_minAddToMakeValid(String s) {
		// TODO Auto-generated method stub
		int open = 0;
        int close = 0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
                open++;
            else
                close++;
        }
        System.out.println(open+" "+close);
        
        if(open==close)
        	return open+1;
        
        return Math.abs(close-open);
	}

}
