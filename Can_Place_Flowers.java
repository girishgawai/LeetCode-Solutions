package arrays;

public class Can_Place_Flowers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] flowerbed = {1,0,0,0,1};
		int n = 2;
		
		System.out.println(canPlaceFlowers(flowerbed,n));
	}

	private static boolean canPlaceFlowers(int[] flowerbed, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < flowerbed.length; i++) {
			if(flowerbed[i]==0)
			{
				boolean flag1 = true;
				if((i-1)>=0 && flowerbed[i-1]==1)
				{
					flag1 = false;
				}
				
				boolean flag2 = true;
				if((i+1)<flowerbed.length && flowerbed[i+1]==1)
					flag2 = false;
				
				if(flag1==true && flag2==true)
				{
					flowerbed[i] = 1;
					n--;
				}
			}
		}
		
		
		return n<=0;				// n se jaada v rkh skte hai 1's.. bss rule valid rhna chahiye and n = 2 dia toh 2 ya 2 se jaada v rkhte aye toh v chlega
	}

}
