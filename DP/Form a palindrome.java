
//https://practice.geeksforgeeks.org/problems/form-a-palindrome1455/1
import java.util.*;

public class Form_a_Palindrome {

	static int countMin(String str) {
		int ans = helper(str.toCharArray(), 0, str.length() - 1, new int[str.length()][str.length()]);
		return ans;
	}
	
	public static int helper(char[] ch, int low, int high, int[][] dp) {
		
		if(low > high) {
			return Integer.MAX_VALUE;
		}
		else if(low == high) {
			return 0;
		}else if(low == high - 1) {
			return ch[low] == ch[high] ? 0 : 1;
		}
		if(dp[low][high] != 0) {
			return dp[low][high];
		}
		
		if(ch[low] == ch[high]) {
			dp[low][high] =  helper(ch, low + 1, high - 1, dp);
			return dp[low][high];
		}else {
			dp[low][high] = Math.min(helper(ch, low + 1, high, dp), helper(ch, low, high - 1, dp)) + 1;
			return dp[low][high];
		}
	}
}
