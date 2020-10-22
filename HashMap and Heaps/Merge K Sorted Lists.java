import java.util.*;
import java.io.*;

public class MergeKSortedList {
	
	public static class Pair implements Comparable<Pair>{
		int li;//List Index
		int di;//Data Index
		int val;//value of data
		
			 Pair(int li,int di,int val){
			this.li = li;
			this.di = di;
			this.val = val;
		}
			 
			 public int compareTo(Pair o) {
				 return this.val - o.val;
			 }
	}
	public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
		ArrayList<Integer> rv = new ArrayList<>();

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < lists.size(); i++) {
			Pair p = new Pair(i,0,lists.get(i).get(0));
			pq.add(p);
		}
		
		while(pq.size() > 0) {
			Pair p1 = pq.remove();
			rv.add(p1.val);
			
			p1.di++;
			if(p1.di < lists.get(p1.li).size()) {
				p1.val = lists.get(p1.li).get(p1.di);
				pq.add(p1);
			}
		}
		return rv;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ArrayList<Integer> list = new ArrayList<>();

			int n = Integer.parseInt(br.readLine());
			String[] elements = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				list.add(Integer.parseInt(elements[j]));
			}

			lists.add(list);
		}

		ArrayList<Integer> mlist = mergeKSortedLists(lists);
		for (int val : mlist) {
			System.out.print(val + " ");
		}
		System.out.println();

	}

}
