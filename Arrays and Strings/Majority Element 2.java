// O(n) - time
// O(1) - space
import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
    public static boolean freqMoreThanNB2(int[] arr, int val){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == val){
                count++;
            }
        }
        return count > arr.length / 3;
    }
    public static ArrayList<Integer> majorityElement2(int[] arr) {
        // write your code here
        int val1 = arr[0];
        int count1 = 1;
        
        int val2 = arr[0];
        int count2 = 0;
        
        for(int i = 1; i < arr.length; i++){
            if(val1 == arr[i]){
                count1++;
            }else if(val2 == arr[i]){
                count2++;
            }else{
                if(count1 == 0){
                    val1 = arr[i];
                    count1 = 1;
                }else if(count2 == 0){
                    val2 = arr[i];
                    count2 = 1;
                }else{
                    count1--;
                    count2--;
                }
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        if(freqMoreThanNB2(arr,val1)){
            res.add(val1);
        }
        if(freqMoreThanNB2(arr,val2) && val1 != val2){
            res.add(val2);
        }
        return res;
        
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        ArrayList<Integer> res = majorityElement2(arr);
        System.out.println(res);
    }
}
