// Recursion

import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
       Scanner scn = new Scanner(System.in);
       int n = scn.nextInt();
       int k = scn.nextInt();
       long ans = helper(n,k);
       System.out.println(ans);
   }
   
   public static long helper(int n,int k){
       if( n == 0 || k == 0){
           return 0;
       }
       if(k == 1){
           return 1;
       }
       
       return helper(n-1,k) * k + helper(n-1,k-1);
   }
}
      
      
//Tabulation

import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
       Scanner scn = new Scanner(System.in);
       int n = scn.nextInt();
       int k = scn.nextInt();
       if(n == 0 || k == 0 || n < k){
           System.out.println(0);
           return;
       }
       
       long[][] dp = new long[k+1][n+1];
       for(int i = 1; i < k + 1; i++){
           for(int j = 1; j < n + 1; j++){
               if(j < i){
                   dp[i][j] = 0;
               }else if(j == i){
                   dp[i][j] = 1;
               }else{
                   dp[i][j] = dp[i-1][j-1] + dp[i][j - 1] * i ;
               }
           }
       }
       System.out.println(dp[k][n]);
   }
}
