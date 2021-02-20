import java.util.*;

public class Main {
	
    public static void completeTask(int n, int m, int[] arr) {
	    HashSet<Integer> set = new HashSet<>();
	    for(int i = 0; i < m; i++){
	        set.add(arr[i]);
	    }
	    
	    ArrayList<Integer> one = new ArrayList<>();
	    ArrayList<Integer> two = new ArrayList<>();
	    boolean flag = true;
	    for(int i = 1; i <= n; i++){
	        if(set.contains(i) == false){
	            if(flag){
	                one.add(i);
	            }else{
	                two.add(i);
	            }
	            
	            flag = !flag;
	        }
	    }
	    
	    for(var ele : one){
	        System.out.print(ele + " ");
	    }
	    
	    System.out.println();
	    
        for(var ele : two){
	        System.out.print(ele + " ");
	    }
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[] num = new int[m];
		for (int i = 0; i < m; i++) {
			num[i] = scn.nextInt();
		}
		completeTask(n, m, num);
	}

}
