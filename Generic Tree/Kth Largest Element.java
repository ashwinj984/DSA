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
