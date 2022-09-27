package leetcode.coomplex.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lexicographical_Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int maxi = sc.nextInt();

		List<Integer> list = new ArrayList<Integer>();
		list = generateLexico(maxi, 0, new ArrayList<Integer>());
		System.out.println(list);
	}

	public static List<Integer> generateLexico(int maxi, int curr, ArrayList<Integer> list)
	{
		if(curr>maxi)
			return list;

		if(curr!=0)
		{
			list.add(curr);
			//			System.out.println(curr);
		}

		int i=0;						// baki har baar k time ke liye.. jb curr ki value 0 nhi hogi.. toh 0 to 9 calls lgege= 10 calls

		if(curr==0)								// first time ke liye.. jb curr ki value 0 hogi.. toh 1 to 9 calls lgege = total 9 calls
			i=1;

		for( ; i<=9; i++)
		{
			generateLexico(maxi, (curr*10) + i, list);
		}

		return list;
	}

}
