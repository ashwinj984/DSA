import java.util.*;
public class Count_Distinct_Subsequences {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		
		HashMap<Character,Integer> map = new HashMap<>();
		long[] dp = new long[str.length() + 1];
		
		dp[0] = 1;
		
		for(int i = 1; i < dp.length; i++) {
			dp[i] = 2 * dp[i - 1];
			if(map.containsKey(str.charAt(i - 1))) {
				int idx = map.get(str.charAt(i - 1));
				dp[i] = dp[i] - dp[idx - 1];
			}
			map.put(str.charAt(i-1),i);
			
		}
		System.out.println(dp[str.length()] - 1);

	}

}
