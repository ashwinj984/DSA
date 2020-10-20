public static Node add(Node node, int data) {
		// write your code

		if (node == null) {
			return new Node(data, null, null);
		}

		if (data > node.data) {
			node.right = add(node.right, data);
		} else if (data < node.data) {
			node.left = add(node.left, data);
		}
		return node;
	}
