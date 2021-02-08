import java.util.*;
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		
		int[] dp = new int[n];
		//dp[0] = 1;
		int omax = 0;
		for(int i = 0; i < n; i++) {
			int max = 0;
			
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					if(dp[j] > max) {
						max = dp[j];
					}
				}
			}
			dp[i] = max + 1;
			
			if(omax < dp[i]) {
				omax = dp[i];
			}
		}
		
		
		System.out.println(omax);
		int ans = recusriveApproach(arr,-1,0);
		System.out.println(ans);
		System.out.println(binarysearchapproach(arr));

	}
	
	//2ND Approach // Recursive
	// Time complexity without memoization 2^n
	//
	public static int recusriveApproach(int[] arr,int prev,int curr) {
		if(arr.length == curr)
			return 0;
		int op1 = 0;
		if(prev == -1 || arr[prev] < arr[curr]) {
			op1 = 1 + recusriveApproach(arr,curr,curr + 1);
		}
		int op2 = recusriveApproach(arr,prev,curr + 1);
		return Math.max(op1,op2);
	}
	//Binary Search Approach
	//Not perfectly coded
	public static int binarysearchapproach(int[] arr) {
		ArrayList<Integer> res = new ArrayList<>();
		res.add(arr[0]);
		for(int i = 1; i < arr.length; i++) {
			if(arr[i - 1] < arr[i]) {
				res.add(arr[i]);
			}else {
				int some = Collections.binarySearch(res, arr[i]);
				res.set(Math.abs(some + 1), arr[i]);
			}
		}
		return res.size();
	}
}
