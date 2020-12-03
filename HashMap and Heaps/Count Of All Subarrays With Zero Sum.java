import java.util.*;

public class Main {

	public static int solution(int[] arr) {
		int count = 0;
		int sum = 0;
		HashMap<Integer,Integer> hm = new HashMap<>();
		hm.put(sum,1);
		for(int i = 0; i < arr.length ; i++){
		    
		    sum += arr[i];
		    if(hm.containsKey(sum)){
		        count += hm.get(sum);
		        hm.put(sum,hm.get(sum) + 1);
		    }else{
		        hm.put(sum,1);
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
		System.out.println(solution(arr));

	}

}
