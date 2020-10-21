import java.util.*;

public class Klargestelement {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scn.nextInt();
		}
		int k = scn.nextInt();

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int val : a) {
			pq.add(val);
		}
		Stack<Integer> st = new Stack<>();
		while (k > 0) {
			st.push(pq.peek());
			pq.remove();
			k--;
		}
		//System.out.println(st);
		int n1= st.size();
		for (int i = 0; i < n1; i++) {
			System.out.println(st.peek());
			st.pop();
		}
	}
}
