import java.io.*;
import java.util.*;

public class Main {


    //left right strategy
  public static int solution(int[] prices) {
      if(prices.length == 0){
          return 0;
      }
      
      if(prices.length == 1){
          return prices[0];
      }
    int[] np = new int[prices.length + 1];
    for(int i = 0; i < prices.length; i++){
        np[i + 1] = prices[i];
    }
    
    int[] dp = new int[np.length];
    dp[0] = 0;
    dp[1] = 1;
    
    for(int i = 2; i < dp.length; i++){
        dp[i] = np[i];
        
        int leftidx = 1;
        int rightidx = i - 1;
        while(leftidx <= rightidx){
            if(dp[leftidx] + dp[rightidx] > dp[i]){
                dp[i] = dp[leftidx] + dp[rightidx];
            }
            
            leftidx++;
            rightidx--;
        }
    }
    return dp[dp.length - 1];

  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] prices = new int[n];
    for (int i = 0; i < n; i++) {
      prices[i] = scn.nextInt();
    }
    System.out.println(solution(prices));
  }

}
