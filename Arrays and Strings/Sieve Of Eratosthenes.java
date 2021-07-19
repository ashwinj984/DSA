import java.util.*;

public class Main {
	// Sieve of Erantosthenes
	// ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
	public static void printPrimeUsingSieve(int n) {
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		for(int i = 2; i * i < isPrime.length; i++) {
			if(isPrime[i]) {
				// make multiples false
				for(int j = i + i; j < isPrime.length; j += i) {
					isPrime[j] = false;
				}
			}
		}
		for(int i = 2; i < isPrime.length; i++) {
			if(isPrime[i]) {
				System.out.print(i + " ");
			}
		}

	}

	// ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		printPrimeUsingSieve(n);
	}
}
