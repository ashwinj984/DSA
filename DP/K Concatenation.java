import java.io.*;
import java.util.*;

public class KConcatenation {
	public static long kadane(int arr[]) {
		long curr = arr[0];
		long max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (curr >= 0)
				curr += arr[i];
			else
				curr = arr[i];
			if (curr > max)
				max = curr;
		}
		return max;
	}

	public static long kadaneTwo(int arr[]) {
		int narr[] = new int[arr.length * 2];
		for (int i = 0; i < arr.length; i++)
			narr[i] = arr[i];
		for (int i = 0; i < arr.length; i++)
			narr[i + arr.length] = arr[i];
		return kadane(narr);
	}

	public static long sum(int arr[]) {
		long s = 0;
		for (int i = 0; i < arr.length; i++)
			s += arr[i];
		return s;
	}

	public static int kConcatenationMaxSum(int[] arr, int k) {
		long sum = sum(arr);
		long res = 0;
		long x = 1000000007;
		if (k == 1)
			res = kadane(arr);
		else if (sum < 0)
			res = kadaneTwo(arr);
		else
			res = kadaneTwo(arr) + (k - 2) * sum;
		if (res < 0)
			return 0;
		return (int) (res % x);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			sum += arr[i];
		}
		int k = scn.nextInt();
		System.out.println(kConcatenationMaxSum(arr, k));
	}

}
