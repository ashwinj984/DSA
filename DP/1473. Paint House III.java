// https://leetcode.com/problems/paint-house-iii/
class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int price = helper(houses, cost, m, n, target, 0, 0, 0, new Integer[m][n + 1][target + 1]);
        return price == Integer.MAX_VALUE ? - 1 : price;
    }
    public int helper(int[] house, int[][] cost, int m, int n, int target, int i, int prev, int nbr, Integer[][][] dp){
        if(nbr > target){
            return Integer.MAX_VALUE;
        }
        if(i == m){
            if(nbr == target){
                return 0;
            }else{
                return Integer.MAX_VALUE;
            }
        }
        if(dp[i][prev][nbr]!=null){
            return dp[i][prev][nbr];
        }
        int minPrice = Integer.MAX_VALUE;
        if(house[i] == 0){
            for(int j = 0; j < n; j++){
                int newNbr = (prev == j + 1) ?  nbr : nbr + 1;
                int price = helper(house, cost, m, n, target, i + 1, j + 1, newNbr, dp);
                if(price != Integer.MAX_VALUE){
                    minPrice = Math.min(minPrice, cost[i][j] + price);
                }
            }
        }else{
            int newNbr = (house[i] == prev) ? nbr : nbr + 1;
            minPrice = Math.min(minPrice, helper(house, cost, m,n, target, i + 1, house[i], newNbr, dp));
        }
        return dp[i][prev][nbr] = minPrice;
    }
}
