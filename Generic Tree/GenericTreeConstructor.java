import java.util.*;

//import com.sun.tools.sjavac.server.SysInfo;
public class GenericTreeConstructor {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
				-1 };
		Node root = null;
		Stack<Node> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				st.pop();
			} else {
				Node t = new Node();
				t.data = arr[i];
				if (st.size() > 0) {
					st.peek().children.add(t);

				} else {
					root = t;
				}
				st.push(t);
			}
		}
		display(root);
		// This is just something i copies
		// something irrelevant
//		Node root = construct(arr);
//	    mSum = Integer.MIN_VALUE;
//	    mSumNode = 0;
//	    nodeWithMaximumSubtreeSum(root);
//	    System.out.println(mSumNode + "@" + mSum);
		diaofGenericTree(root);
		System.out.println(dia);

	}

	public static int size(Node node) {
		int s = 0;

		for (Node child : node.children) {
			s += size(child);
		}
		s += 1;

		return s;
	}

	public static int max(Node node) {
		int m = Integer.MIN_VALUE;

		for (Node child : node.children) {
			int cm = max(child);
			m = Math.max(m, cm);
		}
		m = Math.max(m, node.data);

		return m;
	}

	public static int height(Node node) {
		int h = -1;// if here we not initiliaze it with -1 then problem will occur if we will have
					// a tree having just one node///

		for (Node child : node.children) {
			int ch = height(child);
			h = Math.max(h, ch);
		}
		h += 1;

		return h;
	}

	public static void traversals(Node node) {
		// Area when you enter in the Node
		System.out.println("Node Pre " + node.data);
		for (Node child : node.children) {
			// area when going through edge
			System.out.println("Edge Pre " + node.data + "--" + child.data);
			traversals(child);
			// area when going out of the edge
			System.out.println("Edge Post " + node.data + "--" + child.data);
		}
		// area coming out of the node or recursion
		System.out.println("Node Post " + node.data);
	}

	public static void display(Node node) {
		String str = node.data + "-->";
		for (Node child : node.children) {
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);
		for (Node child : node.children) {
			display(child);
		}
	}

	public static int lca(Node node, int d1, int d2) {
		ArrayList<Integer> p1 = nodeToRootPath(node, d1);
		ArrayList<Integer> p2 = nodeToRootPath(node, d2);
		int i = p1.size() - 1;
		int j = p2.size() - 1;
		while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
			i--;
			j--;
		}
		i++;
		j++;

		return p1.get(i);
	}

	public static int distanceBetweenNodes(Node node, int d1, int d2) {
		ArrayList<Integer> p1 = nodeToRootPath(node, d1);
		ArrayList<Integer> p2 = nodeToRootPath(node, d2);

		int i = p1.size() - 1;
		int j = p2.size() - 1;

		while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
			i--;
			j--;
		}
		i++;
		j++;
		return i + j;
	}

	public static boolean areSimilar(Node n1, Node n2) {
		if (n1.children.size() != n2.children.size()) {
			return false;
		}

		for (int i = 0; i < n1.children.size(); i++) {
			Node c1 = n1.children.get(i);
			Node c2 = n1.children.get(i);

			if (areSimilar(c1, c2) == false) {
				return false;
			}
		}
		return true;
	}

	public static boolean areMirror(Node n1, Node n2) {
		if (n1.children.size() != n2.children.size()) {
			return false;
		}

		for (int i = 0; i < n1.children.size(); i++) {
			Node c1 = n1.children.get(n1.children.size() - i - 1);
			Node c2 = n2.children.get(i);

			if (areMirror(c1, c2) == false) {
				return false;
			}

		}
		return true;

	}

	public static boolean IsSymmetric(Node node) {
		return areMirror(node, node);
	}
	// Mutilsolver
	// A kind of new approach

	static int size;
	static int min;
	static int max;
	static int height;

	public static void multiSolver(Node node, int depth) {
		size++;
		max = Math.max(node.data, max);
		min = Math.min(node.data, max);
		height = Math.max(height, depth);
		for (Node child : node.children) {
			multiSolver(child, depth + 1);
		}
	}

	static Node predecessor;
	static Node successor;
	static int state;

	public static void predecessorAndSuccessor(Node node, int data) {

		if (state == 0) {
			if (node.data == data) {
				state = 1;
			} else {
				predecessor = node;
			}
		} else if (state == 1) {
			successor = node;
			state = 2;
		}
		for (Node child : node.children) {
			predecessorAndSuccessor(child, data);

		}
	}

	static int ceil;
	static int floor;

	public static void ceilAndFloor(Node node, int data) {

		if (node.data > data) {
			if (ceil > node.data) {
				ceil = node.data;
			}
		}
		if (node.data < data) {
			if (floor < node.data) {
				floor = node.data;
			}
		}
		for (Node child : node.children) {
			ceilAndFloor(child, data);
		}
	}

	public static int kthLargest(Node node, int k) {
		floor = Integer.MIN_VALUE;
		int factor = Integer.MAX_VALUE;

		for (int i = 0; i < k; i++) {
			ceilAndFloor(node, factor);
			factor = floor;
			floor = Integer.MIN_VALUE;
		}
		return factor;
	}

	public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
		if (node.data == data) {
			ArrayList<Integer> kgf = new ArrayList<>();
			kgf.add(node.data);
			return kgf;
		}

		for (Node child : node.children) {
			ArrayList<Integer> kgf = nodeToRootPath(child, data);
			if (kgf.size() > 0) {
				kgf.add(node.data);
				return kgf;
			}
		}

		return new ArrayList<>();
	}

	public static boolean find(Node node, int data) {

		if (node.data == data) {
			return true;
		}
		for (Node child : node.children) {
			boolean k = find(child, data);
			if (k)
				return true;

		}
		return false;

	}

	public static void LevelOrder(Node node) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(node);
		while (q.size() > 0) {
			node = q.remove();
			System.out.println(node.data + " ");
			for (Node child : node.children) {
				q.add(child);
			}
		}
		System.out.println(".");
	}

	public static void levelOrderLinewise(Node node) {
		Queue<Node> mq = new ArrayDeque<>();
		Queue<Node> cq = new ArrayDeque<>();

		mq.add(node);

		while (mq.size() > 0) {

			node = mq.remove();
			System.out.print(node.data + " ");
			for (Node child : node.children) {
				cq.add(child);
			}
			if (mq.size() == 0) {
				System.out.println();
				mq = cq;
				cq = new ArrayDeque<>();
			}
		}
	}

	// another approach for the above function
	public static void LevelOrder2(Node node) {
		Queue<Node> mq = new ArrayDeque<>();
		mq.add(node);
		while (mq.size() > 0) {
			int cicl = mq.size();// cicl --> children in current loop
			for (int i = 0; i <= cicl; i++) {
				node = mq.remove();
				System.out.print(node.data + " ");
				for (Node child : node.children) {
					mq.add(child);
				}
			}
			System.out.println();
		}
	}

	public static void mirrorGenericTree(Node node) {
		for (Node child : node.children) {
			mirrorGenericTree(child);
		}
		Collections.reverse(node.children);
	}

	public static void removeleaves(Node node) {
		for (int i = node.children.size() - 1; i >= 0; i--) {
			Node child = node.children.get(i);
			if (child.children.size() == 0) {
				node.children.remove(child);
			}
		}
		for (Node child : node.children) {
			removeleaves(child);
		}
	}

	public static void linearize(Node node) {
		for (Node child : node.children) {
			linearize(child);
		}

		while (node.children.size() > 1) {
			Node lc = node.children.remove(node.children.size() - 1);
			Node sc = node.children.get(node.children.size() - 1);
			Node sltail = getTail(sc);
			sltail.children.add(lc);
		}

	}

	// This function is written to find what is the last node of the children
	// So as to connect it to the pre removed node
	private static Node getTail(Node node) {
		while (node.children.size() == 1) {
			node = node.children.get(0);
		}
		return node;
	}

	public static void levelOrderZigZag(Node node) {
		Stack<Node> ms = new Stack<>();
		ms.push(node);
		Stack<Node> cs = new Stack<>();
		int level = 1;
		while (ms.size() > 0) {
			node = ms.pop();
			System.out.print(node.data + " ");
			if (level % 2 == 1) {
				for (int i = 0; i < node.children.size(); i++) {
					Node child = node.children.get(i);
					cs.push(child);
				}
			} else {
				for (int i = node.children.size() - 1; i >= 0; i--) {
					Node child = node.children.get(i);
					cs.push(child);
				}
			}
			if (ms.size() == 0) {
				ms = cs;
				cs = new Stack<>();
				level++;
				System.out.println();
			}
		}

	}

	static int mSum = 0;
	static int mSumNode = 0;

	public static int nodeWithMaximumSubtreeSum(Node node) {
		int sum = 0;

		for (Node child : node.children) {
			int cstSum = nodeWithMaximumSubtreeSum(child);
			sum += cstSum;
		}
		sum += node.data;

		if (sum > mSum) {
			mSum = sum;
			mSumNode = node.data;
		}

		return sum;
	}

	static int dia = 0;

	public static int diaofGenericTree(Node node) {
		int dch = -1;
		int sdch = -1;

		for (Node child : node.children) {
			int ch = diaofGenericTree(child);
			if (ch > dch) {
				sdch = dch;
				dch = ch;
			} else if (ch > sdch) {
				sdch = ch;
			}
		}
		if (dch + sdch + 2 > dia) {
			dia = dch + sdch + 2;
		}

		dch += 1;

		return dch;
	}

	static class Pair {
		Node node;
		int state;

		Pair(Node node, int state) {
			this.node = node;
			this.state = state;
		}
	}

	public static void IterativePreandPostOrder(Node node) {
		Pair p = new Pair(node, -1);
		Stack<Pair> st = new Stack<>();
		st.push(p);

		String preOrder = "";
		String postOrder = "";

		while (st.size() > 0) {
			Pair top = st.peek();
			if (top.state == -1) {
				preOrder += top.node.data + " ";
				top.state++;
			} else if (top.state >= 0 && top.state < top.node.children.size()) {
				Pair cp = new Pair(top.node.children.get(top.state), -1);
				st.push(cp);

				top.state++;
			} else {
				postOrder += top.node.data + " ";
				st.pop();
			}
		}

		System.out.println(preOrder);
		System.out.println(postOrder);
	}

	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

}
