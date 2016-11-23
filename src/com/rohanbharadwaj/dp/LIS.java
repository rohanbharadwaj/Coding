package com.rohanbharadwaj.dp;

import java.util.Arrays;

public class LIS {
	public int solve(int[] a) {
		int n = a.length;
		int[] memo = new int[n];
		int[] R = new int[n];
		Arrays.fill(memo, 1);
		Arrays.fill(R, -1);
		int res = 0;
		for (int i = 1; i < memo.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && memo[i] < memo[j] + 1) {
					memo[i] = memo[j] + 1;
					R[i] = j;
				}
			}
		}
		int startIndex = 0;
		for (int j = 0; j < memo.length; j++) {
			if (res < memo[j]) {
				res = memo[j];
				startIndex = j;
			}
		}
		printSolution(startIndex, R, a, res);
		return res;
	}

	public void printSolution(int startIndex, int[] R, int[] a, int res) {
		int[] sol = new int[res];
		int i = res - 1;
		while (startIndex > -1) {
			// System.out.print(a[startIndex]);
			sol[i--] = a[startIndex];
			startIndex = R[startIndex];
		}
		System.out.println("LIS : " + Arrays.toString(sol));
	}

	public static void main(String[] args) {
		LIS obj = new LIS();
		int[] a = { 5, 3, 4, 8, 6, 7 };
		int res = obj.solve(a);
		System.out.println(res);

	}
}
