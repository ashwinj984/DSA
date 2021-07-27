import java.util.*;

public class Main {

	// ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~
	public static boolean validPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while(i <= j) {
			char ch1 = s.charAt(i);
			char ch2 = s.charAt(j);
			if(ch1 == ch2) {
				i++;
				j--;
			}else {
				 boolean flag1 = checkPalindrome(i + 1, j, s);
				 boolean flag2 = checkPalindrome(i, j - 1, s);
				 return flag1 || flag2;
 			}
		}
		
		return true;
	}
	
	public static boolean checkPalindrome(int i, int j, String s) {
		while(i < j) {
			char ch1 = s.charAt(i);
			char ch2 = s.charAt(j);
			if(ch1 != ch2) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	// ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();

		boolean res = validPalindrome(str);
		System.out.println(res);
	}
}
