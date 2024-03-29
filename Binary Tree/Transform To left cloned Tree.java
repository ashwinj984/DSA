
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
