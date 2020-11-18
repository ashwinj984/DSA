import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        
        int k = scn.nextInt();
        
        int[][] dp = new int[k+1][n];
        
        for(int t = 1; t < k + 1; t++){
            for(int d = 1; d < n; d++){
                int max = dp[t][d-1];
                for(int pd = 0; pd < d; pd++){
                    int one = dp[t-1][pd];
                    int diff = arr[d] - arr[pd];
                    if(one + diff > max){
                        max = one + diff;
                    }
                }
                dp[t][d] = max;
            }
        }
        System.out.println(dp[k][n-1]);
    }

}

//optimized version

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();

        int[][] dp = new int[k + 1][n];

        for (int t = 1; t < k + 1; t++) {
            int max = Integer.MIN_VALUE;
            for (int d = 1; d < n; d++) {
                if (dp[t - 1][d - 1] - arr[d - 1] > max) {
                    max = dp[t - 1][d - 1] - arr[d - 1];
                }

                if (max + arr[d] > dp[t][d - 1]) {
                    dp[t][d] = max + arr[d];
                } else {
                    dp[t][d] = dp[t][d - 1];
                }
            }
        }
        System.out.println(dp[k][n - 1]);
    }

}
