package com.rohanbharadwaj.dp;

import java.util.Arrays;

public class MinCoins {
	private static int solve(int[] val,int sum) {
		int maxVal = val.length;
		int[] minK = new int[sum+1];
		Arrays.fill(minK, Integer.MAX_VALUE);
		minK[0] = 0;
		for(int i=1;i<=sum;i++){
			for (int j = 0; j < maxVal; j++) {
				if(val[j]<=i){
					int sub = minK[i-val[j]];
					if(sub != Integer.MAX_VALUE && sub+1< minK[i])
					minK[i] = sub+1;
				}
			}
		}
		return minK[sum] == Integer.MAX_VALUE ? -1 : minK[sum];
	}
	
	public static void main(String[] args) {
		int res = solve(new int[] {2}, 3);
		System.out.println(res);
		System.out.println(Integer.MAX_VALUE);
	}
}