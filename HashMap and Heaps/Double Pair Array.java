import java.util.*;

public class Main {

    public static boolean solution(int[] arr) {
        if(arr.length == 0){
            return true;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i],map.getOrDefault(arr[i], 0) + 1);
        }
        
        Integer[] ans = new Integer[arr.length];
        for(int i = 0; i < ans.length; i++){
            ans[i] = arr[i];
        }
        Arrays.sort(ans, (a,b) ->{
           return Math.abs(a) - Math.abs(b); 
        });
        for(var ele : ans){
            if(map.get(ele) == 0){
                continue;
            }
            
            if(map.getOrDefault(2 * ele, 0) == 0){
                return false;
            } 
            
            map.put(ele, map.get(ele) - 1);
            map.put(2 * ele, map.get(2 * ele) - 1);
        }
        return true;
    }
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
