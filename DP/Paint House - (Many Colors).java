import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); //Number of house
        int c = scn.nextInt(); //NUmber of colours

        int[][] arr = new int[n][c];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[n][c];

        for (int i = 0; i < c; i++) {
            dp[0][i] = arr[0][i];
        }


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < c; j++) {
                int min = Integer.MAX_VALUE;

                for (int k = 0; k < c; k++) {
                    if (k != j) {
                        if (dp[i - 1][k] < min) {
                            min = dp[i - 1][k];
                        }
                    }
                }

                dp[i][j] = arr[i][j] + min;

            }
        }
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < c; k++) {

            if (dp[n - 1][k] < min) {
                min = dp[n - 1][k];
            }

        }
        System.out.println(min);
    }
}
