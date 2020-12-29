import java.io.*;
import java.util.*;

public class Main {
    
    public static class Bridges implements Comparable<Bridges>{
		int n;
		int s;
		Bridges(int n,int s){
			this.n = n;
			this.s = s;
		}
		public int compareTo(Bridges o) {
			if(this.n != o.n) {
				return this.n - o.n;
			}else {
				return this.s - o.s;
			}
		}
	}

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
		int n = Integer.parseInt(scn.nextLine());
		Bridges[] b = new Bridges[n];
		for(int i = 0; i < n; i++) {
			String s = scn.nextLine();
			String[] parts = s.split(" ");
			int nr = Integer.parseInt(parts[0]);
			int sr = Integer.parseInt(parts[1]);
			b[i] = new Bridges(nr,sr);
		}
		
		Arrays.sort(b);
		
		int[] dp = new int[b.length];
		int omax = 0;
		for(int i = 0; i < dp.length; i++) {
			int max = 0;
			for(int j = 0; j < i; j++) {
				if(b[j].s <= b[i].s) {
					if(dp[j] > max) {
						max = dp[j];
					}
				}
			}
			dp[i] = max + 1;
			if(omax < dp[i]) {
				omax = dp[i];
			}
		}
		System.out.println(omax);
    }

}
