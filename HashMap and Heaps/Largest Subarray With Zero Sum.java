import java.util.*;

public class Main {
	
	public static int solution(int[] arr) {
		 int maxlen = 0;
		 int i = -1;
		 int sum = 0;
		 HashMap<Integer,Integer> map = new HashMap<>();
		 map.put(sum,-1);
		 while(i < arr.length - 1){
		     i++;
		     sum+=arr[i];
		     if(!map.containsKey(sum)){
		         map.put(sum,i);
		     }else{
		         int len = i - map.get(sum);
		         if(maxlen < len){
		             maxlen = len;
		         }
		     }
		 }

		return maxlen;
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
