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
