import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        int ans = 0;
        HashMap<String,Integer> map = new HashMap<>();
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int delta10 = count1-count0;
        int delta21 = count2 - count1;
        String key = delta21 +"#" + delta10;
        map.put(key,-1);
        for(int i = 0; i < arr.length;i++){
            if(arr[i] == 0){
                count0++;
            }else if(arr[i] == 1){
                count1++;
                
            }else if(arr[i] == 2){
                count2++;
            }
            
            delta10 = count1 - count0;
            delta21 = count2 - count1;
            
            key = delta21 +"#" + delta10;
            if(map.containsKey(key)){
                int len = i - map.get(key);
                if(len > ans){
                    ans = len;
                }
            }
            else{
                map.put(key,i);
            }
        }
        return ans;
        
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}Longest Subarray With Equal Number Of 0s 1s And 2s
