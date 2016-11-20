package com.rohanbharadwaj.dp;

import java.util.Arrays;

public class LIS {
	private static int solve(int[] a) {
		int n = a.length;
		int[] memo = new int[n];
		Arrays.fill(memo, 1);
		int res = 0;
		for (int i = 1; i < memo.length; i++) {
			for (int j = 0; j < i; j++) {
				if(a[i]>a[j] && memo[i]<memo[j]+1){
					memo[i] = memo[j] + 1;
				}
			}
		}
		for (int j = 0; j < memo.length; j++) {
			res = Math.max(res, memo[j]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] a = { 5, 3, 4, 8, 6, 7 };
		int res = solve(a);
		System.out.println(res);
		
	}

}
