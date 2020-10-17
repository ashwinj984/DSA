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
