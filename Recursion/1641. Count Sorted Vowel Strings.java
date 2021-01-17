import java.util.*;

public class CountSortedVowelStrings {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String combination = "";
		solution(combination, n);
		System.out.println(ans);
		//System.out.println(arr);

	}

	static int ans = 0;
	static ArrayList<String> arr = new ArrayList<>();
	public static void solution(String combination , int n) {
		if(combination.length() == n && combination.length() != 0) {
			arr.add(combination);
			ans++;
			return;
		}
		
		if(combination.length() == 0) {
			solution(combination + 'a' , n);
			solution(combination + 'e' , n);
			solution(combination + 'i' , n);
			solution(combination + 'o' , n);
			solution(combination + 'u' , n);
		}else {
			if(combination.charAt(combination.length() - 1) == 'a') {
				solution(combination + 'a' , n);
				solution(combination + 'e' , n);
				solution(combination + 'i' , n);
				solution(combination + 'o' , n);
				solution(combination + 'u' , n);
			}
			
			if(combination.charAt(combination.length() - 1) == 'e') {
				//solution(combination + 'a' , n);
				solution(combination + 'e' , n);
				solution(combination + 'i' , n);
				solution(combination + 'o' , n);
				solution(combination + 'u' , n);
			}
			
			if(combination.charAt(combination.length() - 1) == 'i') {
				//solution(combination + 'a' , n);
				//solution(combination + 'e' , n);
				solution(combination + 'i' , n);
				solution(combination + 'o' , n);
				solution(combination + 'u' , n);
			}
			
			if(combination.charAt(combination.length() - 1) == 'o') {
//				solution(combination + 'a' , n);
//				solution(combination + 'e' , n);
//				solution(combination + 'i' , n);
				solution(combination + 'o' , n);
				solution(combination + 'u' , n);
			}
			
			if(combination.charAt(combination.length() - 1) == 'u') {
				//solution(combination + 'a' , n);
				//solution(combination + 'e' , n);
				//solution(combination + 'i' , n);
				//solution(combination + 'o' , n);
				solution(combination + 'u' , n);
			}
		}
		
	}
}
//Not a great solution but self explanatory

