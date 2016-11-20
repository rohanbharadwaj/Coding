package com.rohanbharadwaj.dp;

public class CoinPerm {
	private static int solveRecusion(int[] coins, int sum, int i) {
		// If negative no possible solution
		if(sum<0){
			return 0;
		}
		// If sum is 0 empty set - 1 solution
		if(sum==0){
			return 1;
		}
		// No solution, all coins used up
		if(i == coins.length && sum > 0){
			return 0;
		}
		return solveRecusion(coins,sum-coins[i],i)+solveRecusion(coins, sum, i+1);
	}
	
	private static int solveBottomUpDP(int[] coins, int amount){
		int[][] memo = new int[coins.length+1][amount+1];
		for (int i = 0; i <= coins.length; i++) {
			memo[i][0] = 1;
		}
		for (int i = 0; i <= amount; i++) {
			memo[0][i] = 0;
		}
		for(int i=1;i<=coins.length;i++){
			for (int val = 1; val <=amount; val++) {
				if(coins[i-1]<=val){
					memo[i][val] = memo[i-1][val]
							+ memo[i][val-coins[i-1]];
				}
				else{
					memo[i][val] = memo[i-1][val];
				}
			}
		}
		return memo[coins.length][amount];
	}
	
	public static void main(String[] args) {
		int amount = 5;
		int[] coins = {1,2,3};
		System.out.println(solveRecusion(coins, amount, 0));
		
		System.out.println(solveBottomUpDP(coins, amount));
	}

}