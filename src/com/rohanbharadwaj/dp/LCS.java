package com.rohanbharadwaj.dp;

public class LCS {
	static int[][] memo;
	static int maxLen;

	private static String getLcs(String s1, String s2) {
		int i, j;
		i = s1.length();
		j = s2.length();
		char[] res = new char[maxLen + 1];
		res[maxLen] = '\0';
		int index = maxLen;
		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				res[index - 1] = s1.charAt(i - 1);
				i--;
				j--;
				index--;
			} else if (memo[i - 1][j] > memo[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
		return new String(res);
	}

	private static int solveBottomUpDP(String s1, String s2) {
		memo = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0 || j == 0) {
					memo[i][j] = 0;
				} else {
					memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
					if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
						memo[i][j] = Math.max(memo[i][j],
								memo[i - 1][j - 1] + 1);
					}
				}
			}
		}
		maxLen = memo[s1.length()][s2.length()];
		return memo[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		String s1 = "quetzalcoatl";
		String s2 = "tezcatlipoca";
		int l = solveBottomUpDP(s1, s2);
		System.out.println(l);
		System.out.println(maxLen);
		System.out.println(getLcs(s1, s2));
	}
}
