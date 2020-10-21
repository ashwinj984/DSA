import java.util.*;

public class longestConsecutiveSequenceofElements {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scn.nextInt();
		}

		HashMap<Integer, Boolean> hm = new HashMap<>();
		for(int val : a) {
			hm.put(val, true);
		}
		
		for(int val : a) {
			if(hm.containsKey(val - 1)) {
				hm.put(val, false);
			}
		}
		int ml = 0;
		int msp = 0;
		for(int val : a) {
			if(hm.containsKey(val)) {
				int tl = 1;
				int tsp = val;
				while(hm.containsKey(tsp + tl)) {
					tl++;
				}
				
				if(ml < tl) {
					msp = tsp;
					ml = tl;
				}
			}
		}
		for(int i = 0; i < ml; i++) {
			System.out.println(msp + i);
		}

	}

}
