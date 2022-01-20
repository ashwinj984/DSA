class Solution{
       public static int kPalindrome(String str, int n, int k) {
		StringBuilder revStr = new StringBuilder(str);
		revStr = revStr.reverse();
		
		int lps = lcs(str, revStr.toString(), n, n);
		if(n - lps <= k) {
			return 1;
		}
		return 0;
	}
	
	public static int lcs(String str1, String str2, int m, int n) {
		int[][] dp = new int[n + 1][m + 1];
		for(int i = dp.length - 2; i >= 0; i--) {
			for(int j = dp[0].length - 2; j >= 0; j--) {
				if(str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = 1 + dp[i + 1][j + 1];
				}else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		return dp[0][0];
	}
}
