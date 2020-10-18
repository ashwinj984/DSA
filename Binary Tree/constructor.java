import java.util.*;
import java.io.*;

public class constructor {
	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static class Pair {
		Node node;
		int state;

		Pair(Node node, int state) {
			this.node = node;
			this.state = state;
		}
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";
		str += node.left == null ? "." : node.left.data + "";
		str += " <- " + node.data + " -> ";
		str += node.right == null ? "." : node.right.data + "";
		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static Node construct(Integer[] arr) {
		Node root = new Node(arr[0], null, null);
		Pair rtp = new Pair(root, 1);

		Stack<Pair> st = new Stack<>();
		st.push(rtp);

		int idx = 0;
		while (st.size() > 0) {
			Pair top = st.peek();
			if (top.state == 1) {
				idx++;
				if (arr[idx] != null) {
					top.node.left = new Node(arr[idx], null, null);
					Pair lp = new Pair(top.node.left, 1);
					st.push(lp);
				} else {
					top.node.left = null;
				}

				top.state++;
			} else if (top.state == 2) {
				idx++;
				if (arr[idx] != null) {
					top.node.right = new Node(arr[idx], null, null);
					Pair rp = new Pair(top.node.right, 1);
					st.push(rp);
				} else {
					top.node.right = null;
				}

				top.state++;
			} else {
				st.pop();
			}
		}

		return root;
	}

	public static int size(Node node) {
		// write your code here
		if (node == null) {
			return 0;
		}
		int ls = size(node.left);
		int rs = size(node.right);
		int ts = ls + rs + 1;

		return ts;
	}

	public static int sum(Node node) {
		// write your code here
		if (node == null) {
			return 0;
		}
		int ls = sum(node.left);
		int rs = sum(node.right);
		int ts = ls + rs + node.data;

		return ts;
	}

	public static int max(Node node) {
		// write your code here
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int ls = max(node.left);
		int rs = max(node.right);
		int maxy = Math.max(node.data, Math.max(ls, rs));

		return maxy;
	}

	public static int height(Node node) {
		// write your code here

		if (node == null) {
			return -1;
		}

		int ls = height(node.left);
		int rs = height(node.right);
		int heighty = Math.max(ls, rs) + 1;

		return heighty;
	}

	public static void traversal(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data + " In pre Order ");
		traversal(node.left);
		System.out.println(node.data + " In In Order ");
		traversal(node.right);
		System.out.println(node.data + " In Post Order ");

	}

	public static void levelOrder(Node node) {
		Queue<Node> mq = new ArrayDeque<>();
		mq.add(node);
		while (mq.size() > 0) {
			int count = mq.size();
			for (int i = 0; i < count; i++) {
				node = mq.remove();
				System.out.print(node.data + " ");
				if (node.left != null) {
					mq.add(node.left);
				}

				if (node.right != null) {
					mq.add(node.right);
				}
			}
			System.out.println();
		}
	}

	public static void iterativePrePostInTraversal(Node node) {
		Stack<Pair> st = new Stack<>();
		Pair rtp = new Pair(node, 1);
		st.push(rtp);
		String pre = "";
		String in = "";
		String post = "";
		while (st.size() > 0) {
			Pair top = st.peek();

			if (top.state == 1) {
				top.state++;
				// System.out.println(node.data);
				pre += top.node.data + " ";
				if (top.node.left != null) {
					Pair lp = new Pair(top.node.left, 1);
					st.push(lp);
				}
			} else if (top.state == 2) {
				top.state++;
				in += top.node.data + " ";
				if (top.node.right != null) {
					Pair rp = new Pair(top.node.right, 1);
					st.push(rp);
				}
			} else {
				post += top.node.data + " ";
				st.pop();
			}
			// System.out.println();
		}
		System.out.println(pre);
		System.out.println(in);
		System.out.println(post);
	}

	static ArrayList<Integer> path;

	public static boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			path.add(node.data);
			return true;

		}

		boolean lh = find(node.left, data);
		if (lh) {
			path.add(node.data);
			return true;
		}
		boolean rh = find(node.right, data);
		if (rh) {
			path.add(node.data);
			return true;
		}
		return false;
	}

	public static void printKLevelsDown(Node node, int k) {
		if (node == null || k < 0) {
			return;
		}
		if (k == 0) {
			System.out.println(node.data);
		}
		printKLevelsDown(node.left, k - 1);
		printKLevelsDown(node.right, k - 1);
	}

	public static void printKLevelsDown1(Node node, int k, Node blocker) {
		if (node == null || k < 0 || blocker == node) {
			return;
		}
		if (k == 0) {
			System.out.println(node.data);
		}
		printKLevelsDown1(node.left, k - 1, blocker);
		printKLevelsDown1(node.right, k - 1, blocker);
	}

	public static boolean find1(Node node, int data) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			path1.add(node);
			return true;

		}

		boolean lh = find(node.left, data);
		if (lh) {
			path1.add(node);
			return true;
		}
		boolean rh = find(node.right, data);
		if (rh) {
			path1.add(node);
			return true;
		}
		return false;
	}

	static ArrayList<Node> path1;

	public static void printKNodesFar(Node node, int data, int k) {
		path1 = new ArrayList<>();
		find1(node, data);
		for (int i = 0; i < path1.size(); i++) {
			printKLevelsDown1(path1.get(i), k - i, i == 0 ? null : path1.get(i - 1));
		}
	}

	public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			sum += node.data;
			if (sum >= lo && sum <= hi) {
				System.out.println(path + node.data);
			}
			return;
		}

		pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, lo, hi);
		pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, lo, hi);
	}

	public static Node createLeftCloneTree(Node node) {
		if (node == null) {
			return null;
		}
		Node lcr = createLeftCloneTree(node.left);
		Node rcr = createLeftCloneTree(node.right);

		Node nn = new Node(node.data, lcr, null);
		node.left = nn;
		node.right = rcr;
		return node;
	}

	public static Node transBackFromLeftClonedTree(Node node) {
		if (node == null) {
			return null;
		}

		Node lnn = transBackFromLeftClonedTree(node.left.left);
		Node rnn = transBackFromLeftClonedTree(node.right);

		node.left = lnn;
		return node;
	}

	public static void printSingleChildNodes(Node node, Node parent) {
		if (node == null) {
			return;
		}

		if (parent != null && parent.left == node && parent.right == null) {
			System.out.println(node.data);
		} else if (parent != null && parent.left == null && parent.right == node) {
			System.out.println(node.data);
		}
		printSingleChildNodes(node.left, node);
		printSingleChildNodes(node.right, node);
	}

	public static Node removeLeaves(Node node) {
		if (node == null) {
			return null;
		}
		if (node.left == null && node.right == null) {
			return null;
		}
		node.left = removeLeaves(node.left);
		node.right = removeLeaves(node.right);

		return node;
	}

	public static int diameter1(Node node) {

		if (node == null) {
			return 0;
		}

		int ld = diameter1(node.left);
		int rd = diameter1(node.right);
		int f = height(node.left) + height(node.right) + 2;

		int dia = Math.max(f, Math.max(ld, rd));
		return dia;
	}

	// Tilt of a BInary tree

	static int tilt = 0;

	public static int tilt(Node node) {
		if (node == null) {
			return 0;
		}

		int ls = tilt(node.left);
		int rs = tilt(node.right);

		int ltilt = Math.abs(ls - rs);
		tilt += ltilt;
		return ls + rs + node.data;
	}

	// Check If the input tree is BST or not
	public static class BSTPair {
		boolean isBST;
		int min;
		int max;
	}

	public static BSTPair isBST(Node node) {
		if (node == null) {
			BSTPair bp = new BSTPair();
			bp.isBST = true;
			bp.min = Integer.MAX_VALUE;
			bp.max = Integer.MIN_VALUE;

			return bp;
		}

		BSTPair lb = isBST(node.left);
		BSTPair rb = isBST(node.right);

		BSTPair mp = new BSTPair();
		mp.isBST = lb.isBST && rb.isBST && (node.data >= lb.max && node.data <= rb.min);
		mp.max = Math.max(node.data, Math.max(lb.max, rb.max));
		mp.min = Math.min(node.data, Math.min(lb.min, rb.min));

		return mp;
	}

	// Is balanced tree Using recursion
	static boolean isBal2 = true;

	public static int isBal(Node node) {
		if (node == null) {
			return 0;
		}

		int lh = isBal(node.left);
		int rh = isBal(node.right);

		if (Math.abs(lh - rh) > 1)
			isBal2 = false;
		int ht = Math.max(lh, rh) + 1;
		return ht;
	}

	// Is balanced tree using Pair
	public static class isBal1 {
		int ht;
		boolean isbalance;

	}

	public static isBal1 isBal11(Node node) {
		if (node == null) {
			isBal1 bp = new isBal1();
			bp.ht = 0;
			bp.isbalance = true;
			return bp;
		}

		isBal1 lp = isBal11(node.left);
		isBal1 rp = isBal11(node.right);

		isBal1 mp = new isBal1();
		mp.ht = Math.max(lp.ht, rp.ht) + 1;
		mp.isbalance = lp.isbalance && rp.isbalance && (Math.abs(lp.ht - rp.ht) <= 1);

		return mp;
	}

	// Largest Subtree BST
	public static class BSTPair1 {
		boolean isBST;
		int min;
		int max;
		Node root;
		int size;
	}

	public static BSTPair1 isBST1(Node node) {
		if (node == null) {
			BSTPair1 bp = new BSTPair1();
			bp.isBST = true;
			bp.min = Integer.MAX_VALUE;
			bp.max = Integer.MIN_VALUE;
			bp.root = null;
			bp.size = 0;
			return bp;
		}

		BSTPair1 lb = isBST1(node.left);
		BSTPair1 rb = isBST1(node.right);

		BSTPair1 mp = new BSTPair1();
		mp.isBST = lb.isBST && rb.isBST && (node.data >= lb.max && node.data <= rb.min);
		mp.max = Math.max(node.data, Math.max(lb.max, rb.max));
		mp.min = Math.min(node.data, Math.min(lb.min, rb.min));

		if (mp.isBST) {
			mp.root = node;
			mp.size = lb.size + rb.size + 1;
		} else if (lb.size > rb.size) {
			mp.root = lb.root;
			mp.size = lb.size;
		} else {
			mp.root = rb.root;
			mp.size = rb.size;
		}

		return mp;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[n];
		String[] values = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			if (values[i].equals("n") == false) {
				arr[i] = Integer.parseInt(values[i]);
			} else {
				arr[i] = null;
			}
		}

		Node root = construct(arr);
//		display(root);
//		
//		int size = size(root);
//	    int sum = sum(root);
//	    int max = max(root);
//	    int ht = height(root);
//	    System.out.println(size);
//	    System.out.println(sum);
//	    System.out.println(max);
//	    System.out.println(ht);

		// levelOrder(root);
//		path = new ArrayList<>();
//		boolean found = find(root, data);
//		System.out.println(found);
//
//		System.out.println(path);
	}
}