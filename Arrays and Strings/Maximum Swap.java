// leetcode 670
import java.util.*;

public class Main {

	// ~~~~~~~~~~User Section~~~~~~~~~~~
	public static String maximumSwap(String num) {
		int n = num.length();
		int[] dp = new int[10];
		for (int i = 0; i < n; i++) {
			char ch = num.charAt(i);
			dp[ch - '0'] = i;
		}
		char[] ch = num.toCharArray();
		boolean flag = false;
		for (int i = 0; i < ch.length; i++) {
			for (int j = 9; j > ch[i] - '0'; j--) {
				if(dp[j] > i) {
					// swapping and break
					char temp = ch[i];
					ch[i] = ch[dp[j]];
					ch[dp[j]] = temp;
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char c : ch) {
			sb.append(c);
		}
		return sb.toString();

	}

	// ~~~~~~~~Input Management~~~~~~~~~
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		String ans = maximumSwap(str);
		System.out.println(ans);
	}
}
