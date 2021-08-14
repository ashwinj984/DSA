class Solution {
    int[][][] dp;
    public int removeBoxes(int[] boxes) {
        dp = new int[102][102][102];
        int n = boxes.length;
        return helper(boxes, 0, n - 1, 0);
    }
    
    public int helper(int[] boxes, int i, int j, int k){
        if(i > j){
            return 0;
        }
        if(dp[i][j][k] > 0){
            return dp[i][j][k];
        }
        
        
        int max = Integer.MIN_VALUE;
        max = (k + 1) * (k + 1) + helper(boxes, i + 1, j, 0);
        
        for(int range = i + 1; range <= j; range++){
            if(boxes[i] == boxes[range]){
                max = Math.max(max, helper(boxes, i + 1, range - 1, 0) + helper(boxes, range, j, k + 1));
            }
        }
        dp[i][j][k] = max;
        return max;
    }
}
