package com.rohanbharadwaj.dp;

/**
 * Write a function that takes two parameters n and k and returns the value of
 * Binomial Coefficient C(n, k). For example, your function should return 6 for
 * n = 4 and k = 2, and it should return 10 for n = 5 and k = 2.
 * 
 * Ref :
 * http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/
 * Algorithm Design Manual pg 280
 * 
 * @author rohan
 *
 */
public class BinomalCofficients {
	private static int solveRescursive(int n, int m) {
		if (n == m || m == 0) {
			return 1;
		}
		return solveRescursive(n - 1, m - 1) + solveRescursive(n - 1, m);
	}

	/**
	 * Time : O(nm) Space :O(nm)
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	private static int solveBottomUpDP(int n, int m) {
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, m); j++) {
				if (j == 0 || i == j) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				}
			}
		}
		return dp[n][m];
	}

	public static void main(String[] args) {
		int n = 5;
		int m = 4;
		System.out.println(solveRescursive(n, m));
		System.out.println(solveBottomUpDP(n, m));
	}

}
