import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str, String asf) {
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }
        
        for(int i = 0; i < str.length(); i++){
            String s1 = str.substring(0, i + 1);
            String s2 = str.substring(i + 1);
            if(isPalindrome(s1)){
                solution(s2,asf + "(" + s1+") ");
            }
        }

    }
    public static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            char ch1 = s.charAt(left);
            char ch2 = s.charAt(right);
            if(ch1 != ch2){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str, "");
    }

}
