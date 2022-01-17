

import java.util.*;

public class MobileNumericKeyboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char keypad[][] = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' }, { '*', '0', '#' } };
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int ans = findCount(keypad, n);
		System.out.println(ans);
	}

	public static int findCount(char[][] keypad, int n) {
		int count = 0;
		if (keypad == null || n == 0) {
			return 0;
		}
		if (n == 1) {
			return 10;
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if (keypad[i][j] != '*' && keypad[i][j] != '#') {
					count += getCountUntill(keypad, i, j, n);
				}
			}
		}
		return count;
	}
	
	public static int getCountUntill(char[][] keypad, int i, int j, int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		
		int move = 0;
		int ro = 0;
		int co = 0;
		int count = 0;
		for(move = 0; move < 5; move++) {
			ro = i + row[move];
			co = j + col[move];
			if(ro >= 0 && ro <= 3 && co >= 0 && co <= 2 && keypad[ro][co] != '*' && keypad[ro][co] != '#') {
				count += getCountUntill(keypad, ro, co, n - 1);
			}
		}
		return count;
	}

	static int[] row = { 0, 0, -1, 0, 1 };
	static int[] col = { 0, -1, 0, 1, 0 };

}
