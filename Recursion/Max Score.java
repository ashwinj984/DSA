import java.util.*;

public class MaxScore {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int nofWords = scn.nextInt();
		String[] words = new String[nofWords];
		for (int i = 0; i < words.length; i++) {
			words[i] = scn.next();
		}
		int nofLetters = scn.nextInt();
		char[] letters = new char[nofLetters];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = scn.next().charAt(0);
		}
		int[] score = new int[26];
		for (int i = 0; i < score.length; i++) {
			score[i] = scn.nextInt();
		}
		if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
				|| score.length == 0) {
			System.out.println(0);
			return;
		}
		int[] farr = new int[score.length];
		for (char ch : letters) {
			farr[ch - 'a']++;
		}
		System.out.println(solution(words, farr, score, 0));
	}

	public static int solution(String[] words, int[] farr, int[] score, int idx) {
		if (idx == words.length) {
			return 0;
		}

		int sno = solution(words, farr, score, idx + 1);// not included

		int sword = 0;
		boolean flag = true;
		String word = words[idx];
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (farr[ch - 'a'] == 0) {
				flag = false;
			}
			farr[ch - 'a']--;
			sword += score[ch - 'a'];
		}
		int syes = 0;
		if (flag) {
			syes = sword + solution(words, farr, score, idx + 1);
		}
        //Backtracking
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			farr[ch - 'a']++;
		}
		return Math.max(sno, syes);

	}

}
