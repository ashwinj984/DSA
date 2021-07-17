import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class Word_Search_2 {

	public static class Node {
		Node[] childs = new Node[26];
		String str = null;
		boolean isAdded = false;
	}

	static Node root;
	static ArrayList<String> ans = new ArrayList<>();

	public static ArrayList<String> findWords(char[][] board, String[] words) {
		root = new Node();
		for (String word : words) {
			insert(root, word);
		}
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				dfs(board, i, j, root, ans, visited);
			}
		}
		return ans;
	}

	public static void dfs(char[][] board, int i, int j, Node root, ArrayList<String> ans, boolean[][] visited) {
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
			return;
		}
		if(root.childs[board[i][j] - 'a'] == null) {
			return;
		}

		Node child = root.childs[board[i][j] - 'a'];
		if (child.str != null) {
			if(child.isAdded == false) {
				ans.add(child.str);
				child.isAdded = true;
			}
			
		}
		visited[i][j] = true;
		dfs(board, i + 1, j, child, ans, visited);
		dfs(board, i - 1, j, child, ans, visited);
		dfs(board, i, j + 1, child, ans, visited);
		dfs(board, i, j - 1, child, ans, visited);

		visited[i][j] = false;

	}
	
	public static boolean outOfBound(int i, int j, char[][] board) {
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return true;
		}
		return false;
	}

	public static void insert(Node curr, String word) {
		//Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (curr.childs[ch - 'a'] == null) {
				curr.childs[ch - 'a'] = new Node();
			}
			curr = curr.childs[ch - 'a'];
		}
		curr.str = word;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(read.readLine());
		int m = Integer.parseInt(read.readLine());
		char[][] board = new char[n][];
		for (int i = 0; i < n; i++) {
			board[i] = read.readLine().trim().toCharArray();
		}
		int count = Integer.parseInt(read.readLine());
		String words[] = new String[count];
		for (int i = 0; i < count; i++) {
			words[i] = read.readLine();
		}

		ArrayList<String> result = findWords(board, words);
		Collections.sort(result);
		System.out.println(result);

	}
}
