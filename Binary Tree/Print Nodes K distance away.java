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
