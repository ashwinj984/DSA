//BRUTE FORCE
import java.util.*;
	
	public class LongestCommonSubsequence {
	
		public static void main(String[] args) {
			Scanner scn = new Scanner(System.in);
			String s1 = scn.next();
			String s2 = scn.next();
			ArrayList<String> arr1 = solution(s1, 0);
			ArrayList<String> arr2 = solution(s2, 0);
	
			int len = 0;
			for (int i = 0; i < arr1.size(); i++) {
				for (int j = 0; j < arr2.size(); j++) {
					if (arr1.get(i).equals(arr2.get(j))) {
						int lenget = arr1.get(i).length();
						if (lenget > len) {
							len = lenget;
						}
					}
				}
			}
			System.out.println(len);
	
		}
	
		public static ArrayList<String> solution(String s, int index) {
			if (index == s.length()) {
				ArrayList<String> res = new ArrayList<>();
				res.add("");
				return res;
			}
	
			ArrayList<String> res = solution(s, index + 1);
			int len = res.size();
			for (int i = 0; i < len; i++) {
				String k = s.charAt(index) + res.get(i);
				res.add(k);
			}
			return res;
		}
	
	}
