import java.util.*;
import java.io.*;

public class Main {

    /*your task is to complete this function which returns true if target exists in the matrix
    else return false*/
    public static boolean search(int[][]matrix,int target) {
        //write your code here
        int lo = 0;
        int hi = matrix.length - 1;
        Integer ans = null;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(matrix[mid][0] <= target && matrix[mid][matrix[0].length - 1] >= target){
                ans = mid;
                break;
            }
            if(matrix[mid][0] < target){
                lo = mid + 1;
            }else if(matrix[mid][0] > target){
                hi = mid - 1;
            }
        }
        //System.out.print(ans);
        if(ans != null){
            lo = 0;
            hi = matrix[ans].length - 1;
           // System.out.print("\n"+hi);
            while(lo <= hi){
                int mid = (hi + lo) / 2;
                if(matrix[ans][mid] < target){
                    lo = mid + 1;
                }else if(matrix[ans][mid] > target){
                    hi = mid - 1;
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int[][]matrix = new int[m][n];

        for(int i=0; i < m;i++) {
            for(int j=0; j < n;j++) {
                matrix[i][j] = scn.nextInt();
            }
        }

        int target = scn.nextInt();

        boolean isFound = search(matrix,target);
        System.out.println(isFound);

    }
}
