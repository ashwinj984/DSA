// Correct Method

import java.util.*;
public class GrayCode {

	public static ArrayList<String> grayCode(int n) {
 	    if(n == 1){
 	        ArrayList<String> bres = new ArrayList<>();
 	        bres.add("0");
 	        bres.add("1");
 	        return bres;
 	    }
 	    
 	    ArrayList<String> rres = grayCode(n - 1);
 	    ArrayList<String> mres = new ArrayList<>();
 	    for(int i = 0; i < rres.size(); i++){
 	        String rstr = rres.get(i);
 	        mres.add("0" + rstr);
 	    }
 	    
 	    for(int i = rres.size() - 1; i >= 0; i--){
 	        String rstr = rres.get(i);
 	        mres.add("1" + rstr);
 	    }
 	    
 	    return mres;
 	}
 
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         ArrayList<String> ans=grayCode(scn.nextInt());
         System.out.println(ans);
     }
 }


// a confusing method
import java.util.*;
 
 public class Main {
 
     public static ArrayList<String> grayCode(int n) {
         if(n == 0){
             ArrayList<String> ans = new ArrayList<>();
             ans.add("0");
             return ans;
         }
 	    if(n == 1){
 	        ArrayList<String> bres = new ArrayList<>();
 	        bres.add("0");
 	        bres.add("1");
 	        return bres;
 	    }
 	    
 	    ArrayList<String> rres = grayCode(n - 1);
 	    ArrayList<String> mres = new ArrayList<>();
 	    for(int i = 0; i < rres.size(); i++){
 	        String rstr = rres.get(i);
 	        mres.add("0" + rstr);
 	    }
 	    
 	    for(int i = rres.size() - 1; i >= 0; i--){
 	        String rstr = rres.get(i);
 	        mres.add("1" + rstr);
 	    }
 	    
 	    return mres;
 	}
 
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         ArrayList<String> ans=grayCode(scn.nextInt());
         ArrayList<Integer> arr = new ArrayList<>();
         for(String str : ans){
            int a = Integer.parseInt(str, 2);
            arr.add(a);
         }
         System.out.print(arr);
     }
 }
