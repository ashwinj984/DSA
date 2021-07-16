import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class Concatenate_Words {
	public static class Node{
		Node childs[] = new Node[26];
		String str;
	}
	static Node root;
	static HashSet<String> ans = new HashSet<>();
	public static void search1(Node curr) {
		if(curr.str != null) {
			search(curr, root);
		}
		
		for(Node child : curr.childs) {
			if(child != null) {
				search1(child);
			}
		}
	}
	public static void search(Node curr, Node nWord) {
		if(curr.str != null && nWord.str != null) {
			ans.add(curr.str);
		}
		if(nWord.str != null) {
			search(curr, root);
		}
		for(int i = 0; i < 26; i++) {
			if(curr.childs[i] != null && nWord.childs[i] != null) {
				search(curr.childs[i], nWord.childs[i]);
			}
		}
	}
	public static List<String> findAllConcatenatedWordsInADict(String[] words) {
		root = new Node();
		for(String s : words) {
			insert(root, s);
		}
		search1(root);
		List<String> list = new ArrayList<>(ans);
        return list;
    }

    private static void insert(Node curr, String s) {
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if(curr.childs[ch- 'a'] == null) {
				curr.childs[ch- 'a'] = new Node();
			}
			curr = curr.childs[ch - 'a'];
		}
		curr.str = s;
		
	}
	public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());

        String[]words = new String[n];

        for(int i=0;i<n;i++){
            words[i] = read.readLine();
        }

        List<String> result = findAllConcatenatedWordsInADict(words);
        Collections.sort(result);
        PrintWriter out = new PrintWriter(System.out);
        for(String s: result){
            out.println(s);
        }
        out.close();
    }
}
//
// Another Approach without HashSet
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class Concatenate_Words {
	public static class Node{
		Node childs[] = new Node[26];
		String str;
	}
	static Node root;
	static ArrayList<String> ans = new ArrayList<>();
	public static void search1(Node curr) {
		if(curr.str != null) {
			search(curr, root);
		}
		
		for(Node child : curr.childs) {
			if(child != null) {
				search1(child);
			}
		}
	}
	public static void search(Node curr, Node nWord) {
		if(curr.str != null && nWord.str != null) {
			ans.add(curr.str);
      // make it null after adding
			curr.str = null;
		}
		if(nWord.str != null) {
			search(curr, root);
		}
		for(int i = 0; i < 26; i++) {
			if(curr.childs[i] != null && nWord.childs[i] != null) {
				search(curr.childs[i], nWord.childs[i]);
			}
		}
	}
	public static List<String> findAllConcatenatedWordsInADict(String[] words) {
		root = new Node();
		for(String s : words) {
			insert(root, s);
		}
		search1(root);
		//List<String> list = new ArrayList<>(ans);
        return ans;
    }

    private static void insert(Node curr, String s) {
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if(curr.childs[ch- 'a'] == null) {
				curr.childs[ch- 'a'] = new Node();
			}
			curr = curr.childs[ch - 'a'];
		}
		curr.str = s;
		
	}
	public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());

        String[]words = new String[n];

        for(int i=0;i<n;i++){
            words[i] = read.readLine();
        }

        List<String> result = findAllConcatenatedWordsInADict(words);
        Collections.sort(result);
        PrintWriter out = new PrintWriter(System.out);
        for(String s: result){
            out.println(s);
        }
        out.close();
    }
}
// One More Approach

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class Concatenate_Words {
	public static class Node{
		Node childs[] = new Node[26];
		String str;
		boolean added = false;
	}
	static Node root;
	static ArrayList<String> ans = new ArrayList<>();
	public static void search1(Node curr) {
		if(curr.str != null) {
			search(curr, root);
		}
		
		for(Node child : curr.childs) {
			if(child != null) {
				search1(child);
			}
		}
	}
	public static void search(Node curr, Node nWord) {
		if(curr.str != null && nWord.str != null) {
			if(curr.added == false)
				ans.add(curr.str);
			curr.added = true;
		}
		if(nWord.str != null) {
			search(curr, root);
		}
		for(int i = 0; i < 26; i++) {
			if(curr.childs[i] != null && nWord.childs[i] != null) {
				search(curr.childs[i], nWord.childs[i]);
			}
		}
	}
	public static List<String> findAllConcatenatedWordsInADict(String[] words) {
		root = new Node();
		for(String s : words) {
			insert(root, s);
		}
		search1(root);
		//List<String> list = new ArrayList<>(ans);
        return ans;
    }

    private static void insert(Node curr, String s) {
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if(curr.childs[ch- 'a'] == null) {
				curr.childs[ch- 'a'] = new Node();
			}
			curr = curr.childs[ch - 'a'];
		}
		curr.str = s;
		
	}
	public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());

        String[]words = new String[n];

        for(int i=0;i<n;i++){
            words[i] = read.readLine();
        }

        List<String> result = findAllConcatenatedWordsInADict(words);
        Collections.sort(result);
        PrintWriter out = new PrintWriter(System.out);
        for(String s: result){
            out.println(s);
        }
        out.close();
    }
}
