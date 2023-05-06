package greedy;

import java.util.Arrays;

public class Assign_Cookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] g = {2,4,2,6,3};	//{1,2};	//{1,2,3};
		int[] s = {4,1,4};	//{1,2,3};	//{1,1};

		System.out.println(findContentChildren(g,s));
	}

	public static int findContentChildren(int[] children, int[] cookies) {
		int childs_got_cookies = 0;
		
		Arrays.sort(children);
		Arrays.sort(cookies);
		
		for (int i = 0, j = 0; i < cookies.length && j < children.length; i++) {
			if(cookies[i]>=children[j])
			{
				childs_got_cookies++;
				j++;
			}
		}
		
		return childs_got_cookies;
	}

}
