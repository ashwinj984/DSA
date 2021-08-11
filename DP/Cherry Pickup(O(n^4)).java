import java.io.*;
import java.util.*;

public class Main {

// ==================== Approach 1 =============================//
	public static int cherryPickup1(int r1, int c1, int r2, int c2, int[][] arr, int[][][][] dp) {
		if (r1 >= arr.length || r2 >= arr.length || c1 >= arr[0].length || c2 >= arr[0].length || arr[r1][c1] == -1
				|| arr[r2][c2] == -1 || arr[r2][c2] == -1) {
			return Integer.MIN_VALUE;
		}
		// if p1 and p2 reach destination
		if (r1 == arr.length - 1 && c1 == arr[0].length - 1) {
			return arr[r1][c1];
		}

		if (dp[r1][c1][r2][c2] != 0) {
			return dp[r1][c1][r2][c2];
		}
		int cherries = 0;

		if (r1 == r2 && c1 == c2) {
			cherries += arr[r1][c1];
		} else {
			cherries += arr[r1][c1] + arr[r2][c2];
		}
		int f1 = cherryPickup1(r1, c1 + 1, r2, c2 + 1, arr, dp);
		int f2 = cherryPickup1(r1 + 1, c1, r2, c2 + 1, arr, dp);
		int f3 = cherryPickup1(r1 + 1, c1, r2 + 1, c2, arr, dp);
		int f4 = cherryPickup1(r1, c1 + 1, r2 + 1, c2, arr, dp);
		cherries += Math.max(Math.max(f1, f2), Math.max(f3, f4));
		dp[r1][c1][r2][c2] = cherries;
		return cherries;
	}

// =================== End =====================//
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		int[][][][] dp = new int[n][n][n][n];
		int ans = cherryPickup1(0, 0, 0, 0, arr, dp);
		if (ans < 0) {
			System.out.println(0);
			return;
		}
		System.out.println(ans);

	}

}
