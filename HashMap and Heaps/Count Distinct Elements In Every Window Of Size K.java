import java.util.*;

public class Main {

	public static ArrayList<Integer> solution(int[] arr, int k) {
		//write your code here

		ArrayList<Integer> list = new ArrayList<>(); 
		HashMap<Integer, Integer> hm = new HashMap<>();
		int i = 0;
		while(i  <= k - 2) {
			hm.put(arr[i],hm.getOrDefault(arr[i], 0) + 1);
			i++;
		}
		
		i--;
		int j = -1;
		while(i < arr.length - 1) {
			i++;
			hm.put(arr[i],hm.getOrDefault(arr[i],0) + 1);
			list.add(hm.size());
			
			j++;
			int freq = hm.get(arr[j]);
			if(freq == 1) {
				hm.remove(arr[j]);
			}else {
				hm.put(arr[j],freq - 1);
			}
		}
			return list;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		ArrayList<Integer> ans = solution(arr,k);
		for(int a : ans){
			System.out.print(a + " ");
		}
	}


}
