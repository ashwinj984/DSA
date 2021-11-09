https://www.geeksforgeeks.org/gold-mine-problem/
import java.util.Arrays;

public class Solution {

	static final int MAX = 100;

	// Returns maximum amount of gold that
	// can be collected when journey started
	// from first column and moves allowed
	// are right, right-up and right-down
	static int getMaxGold(int gold[][], int m, int n) {

		// boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < gold.length; i++) {
			goAndCollectGold(i, m, n, gold, 0, 0);
		}
		return max;
	}

	static int max = Integer.MIN_VALUE;

	public static void goAndCollectGold(int row, int m, int n, int[][] gold, int col, int stn) {
		if (row < 0 || col < 0 || row >= m || col >= n) {
			if (stn > max) {
				max = stn;
			}
			return;
		}

		stn += gold[row][col];
		goAndCollectGold(row - 1, m, n, gold, col + 1, stn);
		goAndCollectGold(row, m, n, gold, col + 1, stn);
		goAndCollectGold(row + 1, m, n, gold, col + 1, stn);

	}

	// driver code
	public static void main(String arg[]) {
		int gold[][] = { { 10, 33, 13, 15 }, { 22, 21, 04, 1 }, { 5, 0, 2, 3 }, { 0, 6, 14, 2 } };
		int m = 4, n = 4;

		System.out.print(getMaxGold(gold, m, n));
	}
}
