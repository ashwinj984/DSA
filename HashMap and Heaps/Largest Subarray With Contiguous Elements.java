import java.util.*;

public class Main {

	public static int solution(int[] arr) {
	int ans = 0;
	
	for(int i = 0 ; i < arr.length - 1; i++){
	    int min = arr[i];
	    int max = arr[i];
	    HashSet<Integer> checkDuplicate = new HashSet<>();
	    checkDuplicate.add(arr[i]);
	    for(int j = i + 1; j < arr.length; j++){
	        if(checkDuplicate.contains(arr[j])){
	            break;
	        }
	        
	        checkDuplicate.add(arr[j]);
	        max = Math.max(max,arr[j]);
	        min = Math.min(min,arr[j]);
	        
	        if(max - min == j - i){
	            int len = j - i + 1;
	            if(len > ans){
	                ans = len;
	            }
	        }
	    }
	}
	return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
