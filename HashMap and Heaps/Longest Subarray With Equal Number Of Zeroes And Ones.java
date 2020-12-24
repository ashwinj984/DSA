import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                sum += -1;
            }else{
                sum += arr[i];
            }
            
            if(map.containsKey(sum) == true){
                int len = i - map.get(sum);
                if(len > ans){
                    ans = len;
                }
            }else{
                map.put(sum,i);
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

}
