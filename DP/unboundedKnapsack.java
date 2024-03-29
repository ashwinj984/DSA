import java.util.*;

public class unboundedKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[] vals = new int[n];
		for (int i = 0; i < vals.length; i++) {
			vals[i] = scn.nextInt();
		}

		int[] wts = new int[n];
		for (int i = 0; i < wts.length; i++) {
			wts[i] = scn.nextInt();
		}

		int cap = scn.nextInt();

		int[] dp = new int[cap + 1];
		dp[0] = 0;

		for (int bagc = 1; bagc < dp.length; bagc++) {
			int max = 0;
			for(int i = 0; i < n; i++) {
				if(wts[i] <= bagc) {
					int rbagc = bagc - wts[i];
					int rbagv = dp[rbagc];
					int totalv = rbagv + vals[i];
					
					if(totalv > max) {
						max = totalv;
					}
				}
			}
			dp[bagc] = max;
		}
		System.out.println(dp[cap]);

	}

}
