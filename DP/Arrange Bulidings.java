import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
		long n = scn.nextInt();// length of the string we want

		long oldCountZeros = 1;
		long oldCountOnes = 1;
		for (int i = 0; i <= n-2; i++) {
			long newCountZeros = oldCountOnes;
			long newCountOnes = oldCountOnes + oldCountZeros;

			oldCountOnes = newCountOnes;
			oldCountZeros = newCountZeros;
		}
		System.out.println((oldCountOnes + oldCountZeros)*(oldCountOnes + oldCountZeros));

 }

}

// Here I just multiplied it because we will have two sides so we have to take
// combinations
