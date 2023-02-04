package arrays;

public class Guess_Number_Higher_or_Lower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10, pick = 6;
		guessNumber(n);
	}
	
	public static int guess(int n) {
		return 7;
	}
	
	public static int guessNumber(int n) {
		int si = 1;
		int ei = n;
		
		while(si<=ei)
		{
//			int mid = (si+ei)/2;
			int mid = si + (ei-si)/2;								// optimized formula for Binary Search
			if(0==guess(mid))				// agr whi number hai guess kia hua toh 0 return krega notation means yes this is the one
				return mid;
			else if(guess(mid)==-1)
				ei = mid-1;
			else
				si = mid+1;
		}
		
		return 1;
	}
}
