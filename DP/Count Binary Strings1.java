import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    // TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();// length of the string we want

		int[] dp0 = new int[n + 1];
		int[] dp1 = new int[n + 1];

		dp0[1] = 1;
		dp1[1] = 1;

		for (int i = 2; i < dp0.length; i++) {

			dp1[i] = dp0[i - 1] + dp1[i - 1];
			dp0[i] = dp1[i - 1];

		}
			System.out.println(dp0[n] + dp1[n]);
 }

}

//More efficient  approach --- >>

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    // TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();// length of the string we want

		int oldCountZeros = 1;
		int oldCountOnes = 1;
		for (int i = 0; i <= n-2; i++) {
			int newCountZeros = oldCountOnes;
			int newCountOnes = oldCountOnes + oldCountZeros;

			oldCountOnes = newCountOnes;
			oldCountZeros = newCountZeros;
		}
		System.out.println(oldCountOnes + oldCountZeros);

 }

}

