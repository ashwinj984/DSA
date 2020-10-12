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
