import java.util.*;

public class sumUptoNusingRecursion {
	// To print array using recursion
	public static void printarray(int[] a, int n) {
		if (n == 0) {
			return;
		}

		printarray(a, n - 1);
		System.out.print(a[n - 1] + " ");

	}
	// To print array in reverse using recursion

	public static void printrevarray(int[] a, int n) {
		if (n == a.length) {
			return;
		}
		printrevarray(a, n + 1);
		System.out.print(a[n] + " ");
	}
	// To print max element of Array using recursion

	public static int maxArr(int[] a, int n) {
		if (n == 0) {
			return a[0];
		}
		int e = 0;
		e = Math.max(maxArr(a, n - 1), e);
		if (a[n - 1] > e)
			return a[n - 1];
		else
			return e;

	}

// to print the max element of array by playing on index only
	public static int findmax(int[] arr, int idx) {
		if (idx == 0)
			return arr[0];
		int largest_element_idxm1 = findmax(arr, idx - 1);
		if (largest_element_idxm1 < arr[idx]) {
			return arr[idx];
		} else {
			return largest_element_idxm1;
		}
	}
	// finding sum of the array using recursion

	public static int sumArr(int[] a, int idx) {
		if (idx == 0)
			return a[0];
		int sum_upto_idxm1 = sumArr(a, idx - 1);
		return a[idx] + sum_upto_idxm1;
	}
	// To check array is sorted or not using array

	public static boolean sortedarr(int[] a, int idx) {
		if (idx == 0)
			return true;
		boolean sorted_idxm1 = sortedarr(a, idx - 1);
		if (sorted_idxm1 == false) {
			return false;
		} else {
			if (a[idx] >= a[idx - 1]) {
				return true;
			} else {
				return false;
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1,2, 3, 4, 5 };
//		printarray(a, a.length);
//		System.out.println();
//		printrevarray(a, 0);
		System.out.println(sortedarr(a, a.length - 1));
	}

}
