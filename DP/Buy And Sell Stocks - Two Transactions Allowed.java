import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        
        int msf = 0;
        int leastsf = arr[0];
        int[] dpl = new int[arr.length];
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < leastsf){
                leastsf = arr[i];
            }
            
            msf = arr[i] - leastsf;
            if(dpl[i-1] < msf){
                dpl[i] = msf;
            }else{
                dpl[i] = dpl[i-1];
            }
        }
        
        int msf1 = 0;
        int maxsf = 0;
        int[] dpr = new int[arr.length];
        for(int i = arr.length - 2; i >= 0; i--){
            if(arr[i] > maxsf){
                maxsf = arr[i];
            }
            
            msf1 = maxsf - arr[i];
            
            if(dpr[i+1] > msf1){
                dpr[i] = dpr[i+1];
            }else{
                dpr[i] = msf1;
            }
        }
        
        int op = 0;
        for(int i = 0; i < arr.length; i++){
            if(dpl[i] + dpr[i] > op){
                op = dpl[i] + dpr[i];
            }
        }
        System.out.println(op);
    }

}
