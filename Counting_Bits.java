package leetcode.coomplex.code;

import java.util.Scanner;

public class Counting_Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int ans[] = count_1_inBinariesTillN(n);
		for (int i = 0; i < ans.length; i++) {

			System.out.print(ans[i] + " ");
		}
	}

	private static int[] count_1_inBinariesTillN(int n) {
		// TODO Auto-generated method stub
		int i = 0;
		int[] ans = new int[n+1];
		while(i<=n)
		{
			int idx = i;
			while(i!=0)
			{
				ans[idx]++;					// uss num ka count bdhayege +1 se 1 milte rhega tb tk
				i = (i-1)&i;
			}

			i = idx + 1;				// firse i ki val idx me thi phle sotre usse +1 krke dalege.. bcaz i toh 0 bn gya bt idx me store hai old i val
		}
		return ans;
	}

}
