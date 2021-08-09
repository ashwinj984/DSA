import java.io.*;
import java.util.*;

public class Main {

	// recursive approach changing string again and again
	public static boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		} else if (s1.equals(s2)) {
			return true;
		}

		for (int i = 1; i < s1.length(); i++) {
			if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
					|| (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
							&& isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))) {
				return true;
			}
		}
		return false;
	}

	// recursive approach keeping string same playing with index
	public static boolean isScramble2(String s1, String s2, int si1, int ei1, int si2, int ei2) {
		if (s1.substring(si1, ei1 + 1).equals(s2.substring(si2, ei2 + 1))) {
			return true;
		}

		for (int i = 0; i < ei1 - si1; i++) {
			if ((isScramble2(s1, s2, si1, si1 + i, si2, si2 + 1)
					&& isScramble2(s1, s2, si1 + i + 1, ei1, si2 + i + 1, ei2))
					|| (isScramble2(s1, s2, si1, si1 + i, ei2 - i, ei2)
							&& isScramble2(s1, s2, si2 + i + 1, ei1, si2, ei2 - i - 1))) {
				return true;
			}
		}
		return false;
	}

	// since length is same so just make a single variable and used memoization
	public static boolean isScramble3(String s1, String s2, int si1, int si2, int len, Boolean[][][] dp) {

		if (s1.substring(si1, si1 + len).equals(s2.substring(si2, si2 + len))) {
			return true;
		}
		if (dp[si1][si2][len] != null) {
			return dp[si1][si2][len];
		}
		for (int i = 1; i < len; i++) {
			if ((isScramble3(s1, s2, si1, si2, i, dp) && isScramble3(s1, s2, si1 + i, si2 + i, len - i, dp))
					|| (isScramble3(s1, s2, si1, si2 + len - i, i, dp)
							&& isScramble3(s1, s2, si1 + i, si2, len - i, dp))) {
				dp[si1][si2][len] = true;
				return true;
			}
		}
		dp[si1][si2][len] = false;
		return false;
	}

	// tabulation method
	public static boolean isScramble4(String s1, String s2) {
		int n = s1.length();
		boolean[][][] dp = new boolean[n][n][n + 1];
		for (int len = 1; len <= n; len++) {
			for (int i = 0; i <= n - len; i++) {
				for (int j = 0; j <= n - len; j++) {
					if (len == 1) {
						dp[i][j][len] = s1.charAt(i) == s2.charAt(j);
					} else {
						for (int k = 1; k < len && !dp[i][j][len]; k++) {
							dp[i][j][len] = (dp[i][j][k] && dp[i + k][j + k][len - k])
									|| (dp[i][j + len - k][k] && dp[i + k][j][len - k]);
						}
					}
				}
			}
		}
		return dp[0][0][n];

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
//		System.out.println(isScramble3(s1, s2, 0, 0, s2.length()));
		int n = s1.length();
		// System.out.println(isScramble3(s1, s2, 0, 0, s2.length(), new Boolean[n][n][n
		// + 1]));
		System.out.println(isScramble4(s1, s2));

	}

}
