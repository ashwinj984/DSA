import java.util.*;
public class keypadproblem {
	public static ArrayList<String> find(String s){
		if(s.length() == 0)
		{
			ArrayList<String> sl = new ArrayList<>();
			sl.add("");
			return sl;
		}
		int len = s.length();
		char ch = s.charAt(0);
		String ros = s.substring(1);
		ArrayList<String> rr = find(ros);
		ArrayList<String> str = new ArrayList<>();
		String seq = getChoice(ch);
		for(String k:rr) {
			for(int i = 0; i < seq.length();i++) {
				String res = seq.charAt(i) + k;
				str.add(res);
				
			}
		}
		return str;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(find("123"));

	}
	public static String getChoice(char key) {
		if (key == '1') {
			return "abc";
		}
		if (key == '2') {
			return "def";
		}
		if (key == '3') {
			return "ghi";
		}
		if (key == '4') {
			return "jkl";
		}
		if (key == '5') {
			return "mno";
		}
		if (key == '6') {
			return "pqrs";
		}
		if (key == '7') {
			return "tuv";
		}
		if (key == '8') {
			return "wx";
		}
		if (key == '9') {
			return "yz";
		}
		if (key == '0') {
			return ".;";
		}
		return "";
	}


}
