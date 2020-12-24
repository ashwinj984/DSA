import java.util.*;

public class Main {

    public static int solution(int[] arr, int k) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0; 
        int rem = 0;
        map.put(0,1);//here 1 indicate number of occurence
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            rem = sum % k;
            if(rem < 0){
                rem = rem + k;
            }
            
            if(map.containsKey(rem) == true){
                count += map.get(rem);
                map.put(rem,map.get(rem) + 1);
            }else{
                map.put(rem,1);
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }

}
