package stacks;

import java.util.Stack;

public class Remove_K_Digits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String num = "1432219";
//		int k = 3;
		
//		String num = "10200";
//		int k = 1;
		
//		String num = "112";
//		int k = 1;
//		
//		String num = "10001";
//		int k = 4;
		
//		String num="1173";
//		int k=2;
		
		String num="100";
		int k=1;
		
		System.out.println(removeKdigits(num, k));
	}

	private static String removeKdigits(String num, int k) {
		// TODO Auto-generated method stub
		if(k==1 && num.length()==1)
		{
			return 0+"";
		}
		
		Stack<Character> st = new Stack<>();
		
		int i = 0;
		st.push(num.charAt(i));
		
		for (int cur = 1; cur < num.length(); cur++) 
		{
			while(!st.isEmpty() && st.peek()>num.charAt(cur) && k>0)
			{
				st.pop();
				k--;
			}
			
//			if(num.charAt(cur)!='0')
				st.push(num.charAt(cur));
		}
		
		System.out.println(st);
		
		if(st.isEmpty())
			return "0";
		
		// maanlo stack me elements bche hue hai.. aur k ki value >0 hai
		while(!st.isEmpty() && k>0)
		{
			st.pop();
			k--;
		}
		
		if(st.isEmpty())
			return "0";
		
		// ha ab bche hue jitne elemetns hai usse bnne wala num hi ans hai.. bss agr preceeding 0 hoge toh unko remove krdo
		StringBuilder smallestnum = new StringBuilder();
		while(!st.isEmpty())
		{
			smallestnum = smallestnum.append(st.pop());
		}
		
		smallestnum.reverse();											// reverse kia bcaz stringbuilder me new data end me add hota hai
		// remove all 0's for the start  e.g 00200 --> 200
		while (!smallestnum.isEmpty()) {
			if(smallestnum.charAt(0)!='0')							// agr starting wala data non zero hai toh kuch dikkt nhi.. whi ans hai
				break;
			smallestnum.deleteCharAt(0);								// agr starting me 0's hai toh unko remove kre bcha hua valid ans
		}

		if(smallestnum.length()==0)
			return "0";
		
		return smallestnum.toString();
	}

}
