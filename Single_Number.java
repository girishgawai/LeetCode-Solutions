package leetcode.coomplex.code;

public class Single_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,1,2,1,2};
		int ans = comesOnce(arr);
		System.out.println(ans);
	}

	private static int comesOnce(int[] arr) { // XOR me dono same nums rhe toh 0 hota dono dif dif rhe toh 1 hota
		// TODO Auto-generated method stub
		int onceCome = arr[0];
		
		for(int i = 1; i<arr.length; i++)
		{
			onceCome = onceCome ^ arr[i];
		}
		return onceCome;
	}

}
