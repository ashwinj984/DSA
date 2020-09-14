	import java.util.*;
	
	public class BalancedBrackets {
		public static void main(String[] args) {
			Scanner scn = new Scanner(System.in);
			String s = scn.nextLine();
			boolean k = true;
			Stack<Character> st = new Stack<>();
			for(int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if(ch == '(' || ch == '{' ||ch == '[') {
					st.push(ch);
				}
				else {
					
				 if(ch == ')') {
					 if(st.size() != 0) {
					char ch1 = st.pop();
					if(ch1 == '(') {
						k = true;
					}else {
						k = false;
					}
				 }
					 else {
						 st.push(ch);
					 }
				 }
					else if(ch == '}') {
						if(st.size() != 0) {
						char ch2 = st.pop();
						if(ch2 == '{') {
							k = true;
						}else {
							k = false;
						}
					}else {
						 st.push(ch);
					 }
					}
					else if(ch == ']') {
						if(st.size() != 0) {
	
				char ch3 = st.pop();
						if(ch3 == '[') {
							k = true;
						}else {
							k = false;
						}
					}else {
						 st.push(ch);
					 }
				}
				}
				
			}
			if(k == true && st.size() == 0) {
			System.out.println(true);
			}
		else {
			System.out.println(false);
		}
		
		}
	}
	
