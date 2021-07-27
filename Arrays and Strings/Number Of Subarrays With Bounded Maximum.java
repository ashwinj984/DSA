import java.util.*;

public class Main {

	public static int numSubarrayBoundedMax(int[] arr, int left, int right) {
		int res = 0;
		int start = 0;
		int end = 0;
		int prevCount = 0;
		while (end < arr.length) {
			if (left <= arr[end] && arr[end] <= right) {
				prevCount = end - start + 1;
				res += prevCount;
			} else if (arr[end] < left) {
				res += prevCount;
			} else if (arr[end] > right) {
				start = end + 1;
				prevCount = 0;
			}
			end++;
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		int left = scn.nextInt();
		int right = scn.nextInt();

		int count = numSubarrayBoundedMax(arr, left, right);
		System.out.println(count);
	}
}
