package com.rohanbharadwaj.dp;

/**
 * @author rohan
 * @Created Nov 20, 2016
 *
 */
public class Knapsack01 {
	public int bottomUpDp(int[] weights, int[] values, int w) {
		int[][] dp = new int[weights.length + 1][w + 1];
		for (int i = 0; i <= weights.length; i++) {
			for (int j = 0; j <= w; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else {
					if (j >= weights[i - 1]) {
						dp[i][j] = Math.max(dp[i - 1][j], values[i - 1]
								+ dp[i - 1][j - weights[i - 1]]);
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
		}
		return dp[weights.length][w];
	}

	public static void main(String[] args) {
		Knapsack01 obj = new Knapsack01();
		int[] weights = new int[] { 1, 3, 4 };
		int[] values = { 1, 4, 5, 7 };
		int w = 7;
		int res = obj.bottomUpDp(weights, values, w);
		System.out.println(res);
	}
}
