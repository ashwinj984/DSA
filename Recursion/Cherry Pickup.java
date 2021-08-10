import java.io.*;
import java.util.*;

public class Main {


	// ==================Backtracking logic starts=================//
	static int max = 0;
	public static void cheeryPickup1(int row, int col, int[][] arr, int cherryCollectedSofar) {
		if (row < 0 || col < 0 || row >= arr.length || col >= arr[0].length || arr[row][col] == -1) {
			return;
		}

		if (row == arr.length - 1 && col == arr[0].length - 1) {
			helper(row, col, arr, cherryCollectedSofar);
		}
		int cheeries = arr[row][col];
		arr[row][col] = 0;
		cheeryPickup1(row, col + 1, arr, cherryCollectedSofar + cheeries);
		cheeryPickup1(row + 1, col, arr, cherryCollectedSofar + cheeries);
		arr[row][col] = cheeries;
	}

	public static void helper(int row, int col, int[][] arr, int cherryCollectedSoFar) {
		if (row < 0 || col < 0 || row >= arr.length || col >= arr[0].length || arr[row][col] == -1) {
			return;
		}
		if (row == 0 && col == 0) {
			max = Math.max(max, cherryCollectedSoFar);
			return;
		}
		int cheeries = arr[row][col];
		arr[row][col] = 0;
		helper(row, col - 1, arr, cherryCollectedSoFar + cheeries);
		helper(row - 1, col, arr, cherryCollectedSoFar + cheeries);
		arr[row][col] = cheeries;
	}

	// =================Backtracking logic end=========================//
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		cheeryPickup1(0, 0, arr, 0);
		System.out.println(max);
	}

}
