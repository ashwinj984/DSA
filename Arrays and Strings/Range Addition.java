// O(n)

import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int[] getModifiedArray(int length, int[][] queries) {
        // write your code here
        int[] arr = new int[length + 1];
        for(int i = 0; i < queries.length; i++){
            int si = queries[i][0];
            int fi = queries[i][1];
            int inc = queries[i][2];
            arr[si] += inc;
            if(fi + 1 <= length){
                arr[fi + 1] -= inc;    
            }
            
        }
        
        int[] prefixSum = new int[length];
        prefixSum[0] = arr[0];
        for(int i = 1; i < length; i++){
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        return prefixSum;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int length = scn.nextInt();

        int nq = scn.nextInt();
        
        int[][] queries = new int[nq][3];

        for(int q = 0; q < nq; q++) {
            queries[q][0] = scn.nextInt();
            queries[q][1] = scn.nextInt();
            queries[q][2] = scn.nextInt();
        }


        int[] res = getModifiedArray(length, queries);

        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
