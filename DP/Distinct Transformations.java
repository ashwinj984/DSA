// using memoization
import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String givenString, String target, int s_pos, int t_pos, int[][] dp) {

		
		if (s_pos == givenString.length()) {
			if (t_pos < target.length()) {
				return 0;
			} else {
				return 1;
			}
		} else if (t_pos == target.length()) {
			return 1;
		}
		if(dp[s_pos][t_pos] != -1) {
			return dp[s_pos][t_pos];
		}
		int ans = 0;
		if (givenString.charAt(s_pos) != target.charAt(t_pos)) {
			ans = solution(givenString, target, s_pos + 1, t_pos, dp);
		} else {
			int ans1 = solution(givenString, target, s_pos + 1, t_pos, dp);
			int ans2 = solution(givenString, target, s_pos + 1, t_pos + 1, dp);
			ans = ans1 + ans2;
		}
		dp[s_pos][t_pos] = ans;
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		int[][] dp = new int[s1.length()][s2.length()];
		for(int[] val : dp) {
			Arrays.fill(val, -1);
		}
		System.out.println(solution(s1, s2, 0, 0, dp));
	}

}

// using tabular method
import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String givenString, String target) {
		int[][] dp = new int[target.length() + 1][givenString.length() + 1];
		for (int i = dp.length - 1; i >= 0; i--) {
			for (int j = dp[0].length - 1; j >= 0; j--) {
				if (i == dp.length - 1) {
					dp[i][j] = 1;
				} else if (j == dp[0].length - 1) {
					dp[i][j] = 0;
				} else {
					char c1 = target.charAt(i);
					char c2 = givenString.charAt(j);
					if (c1 != c2) {
						dp[i][j] = dp[i][j + 1];
					} else {
						dp[i][j] = dp[i + 1][j + 1] + dp[i][j + 1];
					}

				}

			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();

		System.out.println(solution(s1, s2));
	}

}
