import java.util.*;

public class Main {

	// ~~~~~~~~~~~~~User Section~~~~~~~~~~~~~
	public static void rotate(int[][] matrix) {
		// write your code here

		//transpose
		transpose(matrix);
		// reverse every row
		reverseRow(matrix);
	}
	
	public static void transpose(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < i; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
	}
	
	public static void reverseRow(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			int left = 0;
			int right = arr.length - 1;
			while(left < right) {
				int temp = arr[i][left];
				arr[i][left] = arr[i][right];
				arr[i][right] = temp;
				left++;
				right--;
			}
		}
	}

	// ~~~~~~~~~~~Input Management~~~~~~~~~~~
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = scn.nextInt();
			}
		}
		rotate(matrix);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
