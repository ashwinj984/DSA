import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int count = 0;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			if(map.get(arr[i]) == null) {
				map.put(arr[i],	arr[i]);
				count++;
			}
			else if(map.getOrDefault(arr[i],0) == 0) {
				count++;
				map.remove(arr[i]);
			}
			else if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) - 1);
				count++;
				if(map.get(arr[i]) == 0) {
					map.remove(arr[i]);
				}
			}
		}
		for(int key : map.keySet()) {
			count += map.get(key);
		}
		System.out.println(count);
       
    }

}
