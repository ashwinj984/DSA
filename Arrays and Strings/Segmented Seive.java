import java.util.*;

public class Main {

	// ~~~~~~~~~~~~~User Section~~~~~~~~~~~~

	public static void segmentedSieveAlgo(int a, int b) {
		// 1. Make a root of b
		int rootb = (int) Math.sqrt(b);
		// false -> prime & true -> not prime
		boolean[] arr = new boolean[b - a + 1];
		// 2. Get prime till root b using seive
		ArrayList<Integer> primes = seive(rootb);

		// 3. Marking using prime
		for (int prime : primes) {
			// find starting index for marking
			int multiple = (int) Math.ceil((a * 1.0) / prime);
			if (multiple == 1) {
				multiple++;
			}

			int indx = multiple * prime - a;
			for (int j = indx; j < arr.length; j += prime) {
				arr[j] = true;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (!arr[i] && i + a != 1) {
				System.out.println((i + a) + " ");
			}
		}

	}

	public static ArrayList<Integer> seive(int num) {
		boolean[] arr = new boolean[num + 1]; // false - > prime & true -> not prime

		for (int i = 2; i * i < arr.length; i++) {
			if (!arr[i]) {
				for (int j = 2 * i; j < arr.length; j += i) {
					arr[j] = true;
				}
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 2; i < arr.length; i++) {
			if (arr[i] == false) {
				ans.add(i);
			}
		}
		return ans;
	}

	// ~~~~~~~~~~~~Input Management~~~~~~~~~~~
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
		segmentedSieveAlgo(a, b);
	}
}
