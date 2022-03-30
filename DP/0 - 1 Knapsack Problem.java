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

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n) 
    { 
        int[][] t = new int[n + 1][w + 1];
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < w + 1; j++){
                if(wt[i - 1] <= j){
                    t[i][j] = Math.max(val[i - 1]  + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                }else{
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][w];
    } 
}
