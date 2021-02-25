// Simple Recursion

import java.util.*;

public class Minimum_Ascii_Delete_Sum_For_Two_Strings {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		int[][] dp = new int[s1.length()][s2.length()];
		for(int[] len : dp) {
			Arrays.fill(len, -1);
		}
		System.out.println(dfs(s1, s2, 0, 0, dp));

	}

	 public static int dfs(String s1, String s2, int p1, int p2, int[][] memo) {
	        
	        if (p1 == s1.length()) {
	            int del = 0;
	            while (p2 != s2.length()) {
	                del += s2.charAt(p2++) + 0;
	            }
	            return del;
	        } else if (p2 == s2.length()) {
	            int del = 0;
	            while (p1 != s1.length()) {
	                del += s1.charAt(p1++) + 0;
	            }
	            return del;
	        }
	        
//	        if (memo[p1][p2] != -1)
//	            return memo[p1][p2];
//	        
	        int val = 0;
	        if (s1.charAt(p1) == s2.charAt(p2)) {
	            val = dfs(s1, s2, p1 + 1, p2 + 1, memo);
	        } else {
	            int a = s1.charAt(p1) + dfs(s1, s2, p1 + 1, p2, memo);
	            int b = s2.charAt(p2) + dfs(s1, s2, p1, p2 + 1, memo);
	            val = Math.min(a, b);
	        }
	        
	        return val;
	    }
}
// Memoization

import java.util.*;

public class Minimum_Ascii_Delete_Sum_For_Two_Strings {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		int[][] dp = new int[s1.length()][s2.length()];
		for(int[] len : dp) {
			Arrays.fill(len, -1);
		}
		System.out.println(dfs(s1, s2, 0, 0, dp));

	}

	 public static int dfs(String s1, String s2, int p1, int p2, int[][] memo) {
	        
	        if (p1 == s1.length()) {
	            int del = 0;
	            while (p2 != s2.length()) {
	                del += s2.charAt(p2++) + 0;
	            }
	            return del;
	        } else if (p2 == s2.length()) {
	            int del = 0;
	            while (p1 != s1.length()) {
	                del += s1.charAt(p1++) + 0;
	            }
	            return del;
	        }
	        
	        if (memo[p1][p2] != -1)
	            return memo[p1][p2];
	        
	        if (s1.charAt(p1) == s2.charAt(p2)) {
	            memo[p1][p2] = dfs(s1, s2, p1 + 1, p2 + 1, memo);
	        } else {
	            int a = s1.charAt(p1) + dfs(s1, s2, p1 + 1, p2, memo);
	            int b = s2.charAt(p2) + dfs(s1, s2, p1, p2 + 1, memo);
	            memo[p1][p2] = Math.min(a, b);
	        }
	        
	        return memo[p1][p2];
	    }
}

// LCS Concept
// Tabulation

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		
		for(int i = dp.length - 1; i >= 0; i--){
		    for(int j = dp[0].length - 1; j >= 0; j--){
		        if(i == dp.length - 1 && j == dp[0].length - 1){
		            dp[i][j] = 0;
		        }else if(j == dp[0].length - 1){
		            dp[i][j] = dp[i + 1][j] + s1.charAt(i);
		        }else if(i == dp.length - 1){
		            dp[i][j] = dp[i][j + 1] + s2.charAt(j);
		        }else{
		            if(s1.charAt(i) == s2.charAt(j)){
		                dp[i][j] = dp[i + 1][j + 1];
		            }else{
		                dp[i][j] = Math.min(s1.charAt(i) + dp[i + 1][j], s2.charAt(j) + dp[i][j + 1]);
		            }
		            
		        }
		    }
		}
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1, s2));
	}

}
