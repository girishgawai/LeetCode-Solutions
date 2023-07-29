package arrays;

public class Median_of_Two_Sorted_Arrays {
	public static void main(String[] args) {
		int[] A = {2,3,7,11,15};
		int[] B = {-1,4,5,8,14};
		int mid = (A.length+B.length)/2;
		
		boolean iseven = true;
		
		if((A.length+B.length)%2!=0)
			iseven=false;
		
		int i=0,j=0;
		int prev = 0;
		while(i<A.length || j<B.length)
		{
			if(mid<0)
				return;
			int a = i<A.length? A[i]: Integer.MAX_VALUE;
			int b = j<B.length? B[j]: Integer.MAX_VALUE;
			if(mid==0 && iseven==false){
				System.out.println(Math.min(a, b));
				return;
			}
			if(mid==0 && iseven==true) {
//				System.out.println(prev+" "+Math.min(a, b));
				double min = Math.min(a, b);
				System.out.println((prev+min)/2);
				return;
			}
			if(a<=b) {
				prev=a;
				i++;
				mid--;
			}
			else if(b<=a) {
				prev=b;
				j++;
				mid--;
			}
		}
	}
}