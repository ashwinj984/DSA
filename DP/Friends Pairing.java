//Brute Force

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(helper(n));
    }
    
    public static int helper(int n){
        if(n == 1 || n == 2){
            return n;
        }
        
        return helper(n-1) + (n - 1) * helper(n-2);
    }

}







// Memoized Version(better)
        |
        |
        | 

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        System.out.println(helper(n, dp));
    }

    public static int helper(int n, int[] dp) {
        if(dp[n] != 0){
            return dp[n];
        }
        if (n == 1 || n == 2) {
            return n;
        }
        dp[n] = helper(n - 1,dp) + (n - 1) * helper(n - 2, dp);
        return dp[n];
    }
}

