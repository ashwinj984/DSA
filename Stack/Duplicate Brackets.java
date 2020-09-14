import java.util.*;
public class Stack1 {
	public static void main(String[] args) {
		String s = "(a + b) + ((c + d))";
		Stack<Character> st = new Stack<>();
		
		for(int  i = 0; i<= s.length(); i++) {
			char ch = s.charAt(i);
			if(ch ==')') {
				if(st.peek() == '(') {
					System.out.println("True");
				}
				else {
					while(st.peek()!='(') {
						st.pop();
					}
					st.pop();
				}
				
			}
			
			else {
			st.push(ch);
			}
			
		}
		
		System.out.println("False");
	}

}
