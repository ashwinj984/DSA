import java.util.*;

public class digest {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int m = scn.nextInt();

		int[] created_by = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			created_by[i] = scn.nextInt();
		}

		int p = scn.nextInt();
		int q = scn.nextInt();

		boolean[][] follow_user = new boolean[m + 1][m + 1];
		for (int i = 1; i <= p; i++) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			follow_user[a][b] = true;
		}

		boolean[][] follow_story = new boolean[m + 1][n + 1];
		for (int i = 1; i <= q; i++) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			follow_story[a][b] = true;
		}

		boolean[][] follow_user_story = new boolean[m + 1][m + 1];
		boolean[][] both_user_follow_same_story = new boolean[m + 1][m + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (follow_story[i][j]) {
					follow_user_story[i][created_by[j]] = true;
					for (int k = 1; k <= m; k++) {
						if (follow_story[k][j]) {
							both_user_follow_same_story[i][k] = true;
						}
					}
				}
			}
		}

		for (int i = 1; i <= m; i++) {
			ArrayList<Pair> ans = new ArrayList<>();
			for (int j = 1; j <= n; j++) {
				int score = 0;
				if (created_by[j] == i || follow_story[i][j]) {
					score = -1;
				} else {
					for (int k = 1; k <= m; k++) {
						int a = 0;
						int b = 0;
						if (i == k)
							a = 0;
						else if (follow_user[i][k])
							a = 3;
						else if (follow_user_story[i][k])
							a = 2;
						else if (both_user_follow_same_story[i][k])
							a = 1;
						else
							a = 0;

						if (created_by[j] == k)
							b = 2;
						else if (follow_story[k][j])
							b = 1;
						else
							b = 0;

						score += a * b;
					}
				}

				ans.add(new Pair(score, j));
			}
			Collections.sort(ans);
			for(int k = 0; k < 3; k++) {
				System.out.print(ans.get(k).idx + " ");
			}
			System.out.println();
		}

	}

	static class Pair implements Comparable<Pair> {
		int score;
		int idx;

		public Pair(int a, int b) {
			this.score = a;
			this.idx = b;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.score != o.score) {
				return o.score - this.score;
			}
			return this.idx - o.idx;
		}
	}

}
