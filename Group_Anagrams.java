package leetcode.coomplex.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Group_Anagrams {
	public static void main(String[] args) {
		String[] arr = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(arr));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();
		
		
		for (int i = 0; i < strs.length; i++) {
			String s = strs[i];
			String key = keyFun(s);
			if(!map.containsKey(key))					// of map me key nhi hai toh bnalo ek space key ke liye
			{
				map.put(key, new ArrayList<>());
			}
			
			map.get(key).add(s);								// key present hai map me ab usme add krdo key pe value
		}

		List<List<String>> ans = new ArrayList<>();
		for(String key: map.keySet())
		{
			ans.add(map.get(key));
		}
		
		return ans;
	}

	public static String keyFun(String str)
	{
		int[] freq = new int[26];						// freq maintaining array of size 26--> bcaz constaint says only lowercase letters
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			freq[ch-'a']++;									// uss char ki freq array me +1 hogi prev value se
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < freq.length; i++) {
			if(freq[i]>0)
			{
				char ch = (char)(i+'a');
				sb.append(ch);
				sb.append(freq[i]);
			}
		}
		return sb.toString();
	}

}
