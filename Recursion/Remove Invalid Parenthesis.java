import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str, int minRemoval, HashSet < String > ans) {
        if (minRemoval == 0) {
            int mrnow = getMin(str);
            if (mrnow == 0) {
                if (ans.contains(str) == false) {
                    System.out.println(str);
                    ans.add(str);
                }
            }
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            solution(left + right, minRemoval - 1, ans);
        }
    }

    public static int getMin(String str) {
        Stack < Character > st = new Stack < > ();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                st.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                if (st.size() == 0) {
                    st.push(')');
                } else if (st.peek() == ')') {
                    st.push(')');
                } else if (st.peek() == '(') {
                    st.pop();
                }
            }
        }
        return st.size();
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int mr = getMin(str);
        solution(str, mr, new HashSet < > ());
    }

}
