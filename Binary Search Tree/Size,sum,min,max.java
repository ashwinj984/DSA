	public static int size(Node node) {
		// write your code here
		if (node == null) {
			return 0;
		}
		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public static int sum(Node node) {
		// write your code here
		if (node == null) {
			return 0;
		}
		int ls = sum(node.left);
		int rs = sum(node.right);

		return ls + rs + node.data;
	}

	public static int max(Node node) {
		// write your code here
		if (node.right != null) {
			return max(node.right);
		} else {
			return node.data;
		}

	}

	public static int min(Node node) {
		// write your code here
		if (node.left != null) {
			return min(node.left);
		} else {
			return node.data;
		}
	}
