/**
 * 
 */
package com.rohanbharadwaj.dp;

import java.util.Arrays;

/**
 * @author Rohan Bharadwaj
 * @created Nov 21, 2016
 *
 */
public class SubSetSum {
	public boolean subSetSumBottomUpDP(int[] set, int sum) {
		boolean[][] dp = new boolean[set.length + 1][sum + 1];
		for (int i = 0; i <= set.length; i++) {
			dp[i][0] = true;
		}
		for (int i = 1; i <= set.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (set[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - set[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		printSolution(dp, set, sum);
		return dp[set.length][sum];
	}

	public void printSolution(boolean[][] dp, int[] set, int sum) {
		if (!dp[set.length][sum]) {
			System.out.println("No solution");
			return;
		}
		int start = set.length;
		int curJ = sum;
		while (start > 0 && curJ > 0) {
			if (dp[start][curJ] && !dp[start - 1][curJ]) {
				System.out.print(set[start - 1] + " ");
				curJ -= set[start - 1];
				start = start - 1;
			} else {
				start = start - 1;
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SubSetSum obj = new SubSetSum();
		int[] set = { 3, 4, 2, 1 };
		int sum = 8;
		boolean res = obj.subSetSumBottomUpDP(set, sum);
		System.out.println("Set " + Arrays.toString(set) + " can form sum "
				+ sum);
	}

}
