// https://leetcode.com/problems/jump-game-vi/
// Correct Approach but TLE
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[n - 1] = nums[n - 1];
        for(int i = n - 1; i >= 0; i--){
            for(int j = 1; j <= k; j++){
                if(i - j >= 0){
                    dp[i - j] = Math.max(dp[i - j], dp[i] + nums[i - j]);
                }
            }
        }
        return dp[0];
    }
}

// Better Approach
class Solution {
    public int maxResult(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        int ans = nums[0];
        int n = nums.length;
        pq.add(new int[]{nums[n - 1], n - 1});
        for(int i = n - 2; i >= 0; i--){
            while(pq.peek()[1] > i + k){
                pq.poll();
            }
            pq.add(new int[]{ans = pq.peek()[0] + nums[i], i});
        }
        return ans;
    }
}
