// Memoized
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] t = new int[n + 1][w + 1];
         int ans = helper(w, wt, val, n, t);
         return ans;
    } 
    
    public static int helper(int w, int wt[], int val[], int n, int[][] t){
        if(n == 0 || w == 0){
            return 0;
        }
        if(t[n][w] != 0){
            return t[n][w];
        }
        
        if(wt[n - 1] <= w){
            return t[n][w] = Math.max(val[n - 1] + helper(w - wt[n - 1], wt, val, n - 1, t), helper(w, wt, val, n - 1, t));
        }else{
            return t[n][w] = helper(w, wt, val, n - 1, t);
        }
    }
}
// tabulation method
