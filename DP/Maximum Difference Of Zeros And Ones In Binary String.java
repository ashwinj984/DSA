import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String str) {
		int ans = 0;
		
		int csum = 0;
		for(int i = 0; i  < str.length(); i++){
		    int val = 0;
		    if(str.charAt(i) == '0'){
		        val = 1;
		    }else{
		        val = -1;
		    }
		    
		    if(csum > 0){
		        csum += val;
		    }else{
		        csum = val;
		    }
		    
		    if(csum > ans){
		        ans = csum;
		    }
		}
		
		if(ans == 0){
		    return -1;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
