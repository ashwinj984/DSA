import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int c = scn.nextInt();

        int[][] arr = new int[n][c];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[arr.length][arr[0].length];


        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;

        for (int i = 0; i < c; i++) {
            dp[0][i] = arr[0][i];

            if (arr[0][i] <= least) {
                sleast = least;
                least = arr[0][i];
            } else if (arr[0][i] <= sleast) {
                sleast = arr[0][i];
            }
        }


        for (int i = 1; i < dp.length; i++) {

            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
            for (int j = 0; j < dp[0].length; j++) {
                if (least == dp[i - 1][j]) {
                    dp[i][j] = arr[i][j] + sleast;
                } else {
                    dp[i][j] = arr[i][j] + least;
                }


                if (dp[i][j] <= nleast) {
                    nsleast = nleast;
                    nleast = dp[i][j];
                } else if (dp[i][j] <= nsleast) {
                    nsleast = dp[i][j];
                }
            }
            
            least = nleast;
            sleast = nsleast;
        }


        System.out.println(least);


    }
}
