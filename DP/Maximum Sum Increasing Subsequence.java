import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		if(arr.length == 1){
		    System.out.println(arr[0]);
		    return;
		}
		int omax = Integer.MIN_VALUE;
		int[] dp = new int[n];
		dp[0] = arr[0];
		int sum = dp[0];
		for (int i = 1; i < n; i++) {
			
			Integer max = 0;
			
			for (int j = 0; j < i; j++) {

				if (arr[i] >= arr[j]) {
					
					if (max == null) {
					
						max = dp[j];
					} 
					else if (max < dp[j]) {
						max = dp[j];
					}
				}
			}

			if (max == null) {
				dp[i] = arr[i];
			} else {
				dp[i] = max + arr[i];
			}
			if(omax < dp[i]) {
				omax = dp[i];
			}
		}
//		for(int i = 0; i < n; i++) {
//			System.out.print(dp[i] + " ");
//		}
		// System.out.println();

		System.out.println(omax);    }

}
