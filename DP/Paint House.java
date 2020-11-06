import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();//Number of house
        
        int[][] arr = new int[n][3];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        int r = arr[0][0];
        int b = arr[0][1];
        int g = arr[0][2];
        
        for(int i = 1; i < n; i++){
            int nr = arr[i][0] + Math.min(b,g);
            int nb = arr[i][1] + Math.min(r,g);
            int ng = arr[i][2] + Math.min(b,r);
            
            r = nr;
            b = nb;
            g = ng;
        }
        
        System.out.println(Math.min(r,Math.min(b,g)));
    }
}
