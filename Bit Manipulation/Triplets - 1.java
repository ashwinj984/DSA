import java.io.*;
import java.util.*;

public class Main {

	public static void solution(int[] arr){
	    // main logic
	    int c  = 0;
	    for(int i = 0; i < arr.length; i++){
	        int val = 0;
	        // check where xor of all numbers is 0 from i to k
	        for(int k = i; k < arr.length; k++){
	            val ^= arr[k];
	            
	            if(val == 0){
	                c += (k - i);     
	            }
	        }
	    }
	    System.out.println(c);
		
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }
}
