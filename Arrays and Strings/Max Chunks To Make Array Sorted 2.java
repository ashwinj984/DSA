import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    public static int maxChunksToSorted2(int[] arr) {
        // write your code here
        int chunckCount = 0;
        int[] lmax = new int[arr.length + 1];
        int[] rmin = new int[lmax.length];
        Arrays.fill(rmin, Integer.MAX_VALUE);
        lmax[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > lmax[i - 1]){
                lmax[i] = arr[i];
            }else{
                lmax[i] = lmax[i - 1];
            }
        }
        
        for(int i = arr.length - 1; i >= 0; i--){
            rmin[i] = Math.min(rmin[i + 1], arr[i]);
        }
        
        // for(int i = 0; i < lmax.length; i++){
        //     System.out.print(lmax[i] + " ");
        // }
        // System.out.println();
        // for(int i = 0; i < rmin.length; i++){
        //     System.out.print(rmin[i] + " ");
        // }
        // System.out.println();
        
        for(int i = 0; i < arr.length; i++){
            if(lmax[i] <= rmin[i + 1]){
                chunckCount++;
            }
        }
        return chunckCount;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = maxChunksToSorted2(arr);
        System.out.println(res);
    }
}
