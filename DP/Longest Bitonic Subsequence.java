import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		
		int[] lis = new int[n];
		//dp[0] = 1;
		//int omax = 0;
		for(int i = 0; i < n; i++) {
			int max = 0;
			
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					if(lis[j] > max) {
						max = lis[j];
					}
				}
			}
			lis[i] = max + 1;
			
		}
		
		int[] lds = new int[n];
		//dp[0] = 1;
		//int omax = 0;
		for(int i = arr.length - 1; i >= 0; i--) {
			int max = 0;
			
			for(int j = arr.length - 1; j > i; j--) {
				if(arr[j] < arr[i]) {
					if(lds[j] > max) {
						max = lds[j];
					}
				}
			}
			lds[i] = max + 1;
		}
		
		int omax = 0;
		for(int i = 0; i < n; i++) {
			if(lds[i] + lis[i] - 1 > omax) {
				omax = lds[i] + lis[i] - 1;
			}
		}
		System.out.println(omax);
    }

}
