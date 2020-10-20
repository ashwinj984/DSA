public static void pir(Node node, int d1, int d2) {
		if (node == null) {
			return;
		}
		pir(node.left, d1, d2);
		if (node.data >= d1 && node.data <= d2) {
			System.out.println(node.data + " ");
		}
		pir(node.right, d1, d2);

	}
