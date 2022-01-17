import java.io.*;
import java.util.*;

public class Main {

	public static void optimalStrategy(int[] arr) {
	    int[][] dp = new int[arr.length][arr.length];
        
        for(int g = 0; g < dp.length; g++){
            for(int i = 0, j = g; j < dp.length; i++, j++){
                if(g == 0){
                    dp[i][j] = arr[i];
                }else if(g == 1){
                    dp[i][j] = Math.max(arr[i], arr[j]);
                }else{
                    int val1 = arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                    int val2 = arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
                    int val = Math.max(val1, val2);
                    dp[i][j] = val;
                }
            }
        }
        System.out.println(dp[0][arr.length - 1]);
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = scn.nextInt();
		}
		optimalStrategy(a);
	}
}

// by memoization

import java.util.*;
public class OptimalStrategyForAGame {
	public static void main(String[] args) {
		int[] arr = {5,3,7,10};
		int[][] dp = new int[arr.length][arr.length];
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp.length; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(optimalValue(arr, 0, arr.length - 1, dp));
	}
	
	public static int optimalValue(int[] arr, int i, int j, int[][] dp) {
		if(i == j) {
			return arr[i];
		}
		if(j == i + 1) {
			return Math.max(arr[i], arr[j]);
		}
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		
		int val1 = arr[i] + Math.min(optimalValue(arr, i + 2, j, dp), optimalValue(arr, i + 1, j - 1, dp));
		int val2 = arr[j] + Math.min(optimalValue(arr, i + 1, j - 1, dp), optimalValue(arr, i, j -2, dp));
		dp[i][j] = Math.max(val1, val2); 
		return dp[i][j];
	}
}
