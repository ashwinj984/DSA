import java.util.*;
public class Count_Palindromic_Substring {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		
		int count = 0;
		boolean[][] dp = new boolean[s.length()][s.length()];
		
		for(int g = 0; g < s.length(); g++) {
			
			for(int i = 0, j = g; j < dp.length; i++,j++) {
				if(g == 0) {
					dp[i][j] = true;
				}else if(g == 1) {
					dp[i][j] = s.charAt(i) == s.charAt(j) ? true : false;
				}else {
					if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
						dp[i][j] = true;
					}else {
						dp[i][j] = false;
					}
				}
				
				if(dp[i][j]) {
					count++;
				}
			}
			
		}
		System.out.println(count);
	}
}
