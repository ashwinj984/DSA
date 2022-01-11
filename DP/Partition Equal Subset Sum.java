class Solution{
    static int equalPartition(int n, int arr[])
    {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
        	sum += arr[i];
        }
        if(sum % 2 != 0) {
        	return 0;
        }
        
        boolean[][] dp = new boolean[sum/2 + 1][n + 1];
        for(int i = 0; i < dp[0].length; i++) {
        	dp[0][i] = true;
        }
        for(int i = 1; i < dp.length; i++) {
        	for(int j = 1; j < dp[0].length; j++) {
        		dp[i][j] = dp[i][j - 1];
        		if(i >=  arr[j - 1]) {
        			dp[i][j] = dp[i][j] || dp[i - arr[j - 1]][j - 1];
        		}
        		
        	}
        }
        if(dp[sum/2][n]) {
        	return 1;
        }
        return 0;
    }
}
