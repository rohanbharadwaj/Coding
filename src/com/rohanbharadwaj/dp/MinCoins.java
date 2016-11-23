package com.rohanbharadwaj.dp;

import java.util.Arrays;

public class MinCoins {
	
	public int mainCoinsBottomUpDp(int[] coins,int sum){
		int[] dp = new int[sum+1];
		int[] r = new int[sum+1];
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		Arrays.fill(r, -1);
		dp[0]=0;//To make sum 0, no coins needed
		for (int i = 0; i < coins.length; i++) {
			for(int j=1;j<=sum;j++){
				if(coins[i]<=j){
					if(1+dp[j-coins[i]]<dp[j]){
						dp[j]=1+dp[j-coins[i]];
						r[j]=i;
					}
				}
			}
		}
		printCoins(r,coins,sum);
		return dp[sum];
	}
	
	public void printCoins(int[] r,int[] coins,int sum){
		if(r[r.length-1]==-1){
			System.out.println("No solution");
			return;
		}
		int start = r.length-1;
		System.out.print("Coins used to form sum "+sum+" : ");
		while(start!=0){
			int j = r[start];
			System.out.print(coins[j]+", ");
			start = start-coins[j];
		}
		System.out.println();
	}
	
	
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
		MinCoins o = new MinCoins();
		int sum = 13;
		int[] coins = {7,3,2,6};
		int ret = o.mainCoinsBottomUpDp(coins, sum);
		System.out.println(ret);
		
		int res = solve(new int[] {2}, 3);
		System.out.println(res);
	}
}