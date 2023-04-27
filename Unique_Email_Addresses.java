package hashmap;

import java.util.HashMap;

public class Unique_Email_Addresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
//		String[] emails = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
		System.out.println(numUniqueEmails(emails));
		
//		System.out.println(emails[0].replace('t', '*'));
	}

	public static int numUniqueEmails(String[] emails) {
		HashMap<String, Boolean> map = new HashMap<>();
		
		for (int i = 0; i < emails.length; i++) 
		{
			String checker = new String();
			int idx_adrs = emails[i].indexOf('@');		//loc--> '@'
			
			checker = emails[i].substring(0, idx_adrs);
			int idx_plus = checker.indexOf('+');		//loc -->'+'
			
			String valid_email = new String();
			if(idx_plus!=-1)
				valid_email = checker.substring(0,idx_plus);
			else
				valid_email = checker.substring(0,idx_adrs);
//			System.out.println(valid_email);
			checker = new String();
			for (int j = 0; j < valid_email.length(); j++) {
				if(valid_email.charAt(j)!='.')
					checker = checker+valid_email.charAt(j);
			}
			valid_email = checker;
//			System.out.println(valid_email+"----"+checker);
//			System.out.println(valid_email);
			valid_email = valid_email+emails[i].substring(idx_adrs);
			
			if(!map.containsKey(valid_email))
			{
				map.put(valid_email, true);
			}
		}

		System.out.println(map);
		return map.size();
	}
}
