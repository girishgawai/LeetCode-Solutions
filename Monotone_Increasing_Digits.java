package greedy;

public class Monotone_Increasing_Digits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 120;
//		int n = 10;
		
		int ans = monotoneIncreasingDigits(n);
		System.out.println(ans);
	}

	private static int monotoneIncreasingDigits(int n) {
		char[] arr = (""+n).toCharArray();								// given num ko string me convert krdia fir uske ek-ek digits ko array me dala
		
		int last_changed_pos = arr.length;				// ye track rkhega ki last time konse pos ka digit chng kia tha	
																// default value number ki len rkhi bcaz agr ek v number alter nh kia means whi num ko return krna hai
		
		for (int i = arr.length-1; i > 0 ; i--) {					// reverse me aare number me ke digits se
			if(arr[i]<arr[i-1])		// agr curr pos ka data prev se chota hai.. toh toh prev wale ko cum kro.. nd uski pos note krlo
			{
				arr[i-1] = --arr[i-1];				// rev wale digit ko cum kia
				last_changed_pos = i-1;				// last chngs kiss pos pe hue usko note krlo.. kyu ki uske aage wale sare digits ko 9 pe set krna hai baadme
														// sbse bda wala valid monotype incr seq bnane k liye
			}
		}
//		System.out.println(arr);
		
		// ab last update agr kia hoga number ke kisi digit pe.. toh usse samne wale sare digits ko 9 krdo incr monotype bnane k liyw
		for (int i = last_changed_pos+1; i < arr.length; i++) {
			arr[i] = '9';
		}
		
		return Integer.parseInt(new String(arr));
	}
	
	// Wrong approach.. ye logic glat hoga jb starting ka digits 1's hoge... eg 120
//	private static int monotoneIncreasingDigits(int n) {
//		// TODO Auto-generated method stub
//		String str = n+"";
//		boolean flag = true;			// will tells if true ho gya means pura number monototype incr hai so whi ans hai
//		for (int i = 1; i < str.length(); i++) {
//			if(str.charAt(i)<str.charAt(i-1))
//			{
//				System.out.println("non monotype increasing order hai..--> means isko solve krna pdega valid bnakr");
//				flag = false;
//				break;
//			}
//		}
//		
//		// agr flag true hi rha.. mtlb woh given number already monotype increasing hi hai.. so usiko return krdo
//		if(flag==true)
//			return n;
//		
//		// ab jb ki biggest monotype number bnana hai given number se jst chota toh bnate hai
//		int ans = 0;
//		for (int i = 1; i < str.length(); i++) {				// given num me jitne digits hai usse ek digit cum sare digits 999.. bnao
//			ans = (ans * 10) + 9;			// sare 99... bnaye hai given number ke digits/length se 1 cum len ka
//		}
//		
//		int first_digit = Integer.parseInt(str.charAt(0)+"");				// sbse phla wala digit lia given number ka
//		
//		if(first_digit==1 && str.length()==2)					// n=120--> ans 119 not 99
//			first_digit = 0;
//		else
//			first_digit = (int) ((first_digit-1) * Math.pow(10, str.length()-1));		// sbse phle digit ko 1 se -minus kia baki sbko 0
//		
//		
//		return first_digit+ans;						// ab jo ans bna hai saaara 99 number swala usko frstdigit ke piche lgado
//	}

}
