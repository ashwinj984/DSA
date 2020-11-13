import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }


        int max = Integer.MIN_VALUE;
        int lo = arr[0];
        int hi = 0;

        while (hi < arr.length) {


            int ans = arr[hi] - lo;
            if (max < ans) {
                max = ans;
            }
            hi++;
            if (hi == arr.length)
                break;
            lo = Math.min(lo, arr[hi]);
        }
        System.out.println(max);
    }

}
