import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int  n = scn.nextInt();
        
        long ans = helper(n);
        System.out.println(ans);
    }
    
    public static long helper(int n){
        if(n == 1 || n == 2){
            return n;
        }
        return  helper(n-1) + helper(n-2);
    }
}
