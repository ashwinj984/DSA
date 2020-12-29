//O(n) Linear Time

import java.util.*;

public class Main {

    public static boolean solution(int[] arr) {
        if(arr.length <= 1){
            return true;
        }
        HashSet<Integer> set = new HashSet<>();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}

			if (min > arr[i]) {
				min = arr[i];
			}

			set.add(arr[i]);
		}
		// Common Difference
		int cd = (int) (max - min) / (arr.length - 1);

		for (int i = 0; i < arr.length; i++) {
			int ai = min + i * cd;
			if (!set.contains(ai)) {
				return false;
			}
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
