import java.util.*;
public class subsequences {

	public static void main(String[] args) {
	
		String s = "abc";
		ArrayList<String> sl = susbsequences1("abc",0);
		for(int i = 0; i < sl.size(); i++) {
			
			System.out.println(sl.get(i));
		}

	}
	
	public static ArrayList<String> susbsequences1(String s,int idx){
		if(idx == s.length())// base case
		{
			ArrayList<String> sl = new ArrayList<>();
			sl.add("");
			return sl;
		}
		ArrayList<String> sl = susbsequences1(s,idx+1);
		int len = sl.size();
		for(int i = 0; i < len; i++) {
			sl.add(s.charAt(idx) + sl.get(i));
		}
		return sl;
	}

}                                                       
