import java.util.*;

public class AllPalindromicPermutations {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (fmap.containsKey(ch)) {
				fmap.put(ch, fmap.get(ch) + 1);
			} else {
				fmap.put(ch, 1);
			}
		}

		Character odd = null;
		int odds = 0;
		int len = 0;
		for (char ch : fmap.keySet()) {
			int freq = fmap.get(ch);
			if (freq % 2 == 1) {
				odds++;
				odd = ch;
			}
			fmap.put(ch, freq / 2);
			len += freq / 2;
		}
		// System.out.println(len);
		// System.out.println(fmap);

		if (odds > 1) {
			System.out.println(-1);
			return;
		}

		printPalindromicPermutations(1, len, fmap, odd, "");

	}

	private static void printPalindromicPermutations(int cs, int ts, HashMap<Character, Integer> fmap, Character odd,
			String string) {

		if (cs > ts) {
			String rev = "";
			for (int i = string.length() - 1; i >= 0; i--) {
				rev += string.charAt(i);
			}
			String res = string;
			if (odd != null) {
				res += odd;
			}
			res += rev;
			System.out.println(res);
			return;
		}
		for (char ch : fmap.keySet()) {
			int freq = fmap.get(ch);
			if (freq > 0) {
				fmap.put(ch, freq - 1);
				printPalindromicPermutations(cs + 1, ts, fmap, odd, string + ch);
				fmap.put(ch, freq);
			}
		}
	}

}
