import java.io.*;
import java.util.*;

public class Replace_Words {

	public static class Node {
		Node[] childs = new Node[26];
		String str = null;
	}

	public static String replaceWords(String dictionary[], String sentence) {
		Node root = new Node();
		for(String s : dictionary) {
			insert(root, s);
		}
		
		 StringBuilder ans = new StringBuilder();
		 StringTokenizer st = new StringTokenizer(sentence);
		 
		 while(st.hasMoreTokens()) {
			 String word = st.nextToken();
			 
			 String prefix = searchWord(root, word);
			 
			 if(prefix != null) {
				 ans.append(prefix);
			 }else {
				 ans.append(word);
			 }
			 
			 ans.append(" ");
		 }
		 
		 ans.deleteCharAt(ans.length() - 1);
		 return ans.toString();
	}

	public static String searchWord(Node root, String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (root.childs[ch - 'a'] != null) {
				root = root.childs[ch - 'a'];
				if (root.str != null) {
					return root.str;
				}
			}else {
				break;
			}
		}
		return null;
	}

	public static void insert(Node root, String s) {
		Node curr = root;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (curr.childs[ch - 'a'] == null) {
				curr.childs[ch - 'a'] = new Node();
			}
			curr = curr.childs[ch - 'a'];
			if(curr.str != null) {
				return;
			}
		}
		curr.str = s;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(read.readLine());

		String[] dictionary = new String[n];

		for (int i = 0; i < n; i++) {
			dictionary[i] = read.readLine();
		}

		String sentence = read.readLine();

		String result = replaceWords(dictionary, sentence);
		System.out.println(result);

	}
}
