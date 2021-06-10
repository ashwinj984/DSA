import java.util.*;
import java.io.*;

public class Main {

    public static class Pair implements Comparable<Pair>{
        int val;
        int gap;
        Pair(){
            
        }
        
        Pair(int val, int gap){
            this.val = val;
            this.gap = gap;
        }
        
        public int compareTo(Pair o){
            if(this.gap == o.gap){
                return this.val - o.val;
            }
            return this.gap - o.gap;
        }
        
    }
    /*find 'k' closest element to 'x' and return answer list*/
    /*elements in answer list should be in ascending order*/
    public static ArrayList<Integer> findClosest(int[]arr,int k,int x) {
        //write your code here
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        for(i = 0; i < k; i++){
            pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
        }
        for(i = k; i < arr.length; i++){
            int gap = Math.abs(arr[i] - x);
            Pair rem = pq.peek();
            if(rem.gap > gap){
                pq.remove();
                pq.add(new Pair(arr[i], gap));
            }
        }
        while(pq.size() > 0){
            Pair rem = pq.remove();
            list.add(rem.val);
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[]args) {

        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();
        int x = scn.nextInt();

        ArrayList<Integer>ans = findClosest(arr,k,x);

        for(int val : ans) {
            System.out.print(val + " ");
        }

    }
}
