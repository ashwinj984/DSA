public static void traversal(Node node) {
		if(node == null) {
			return;
		}
		System.out.println(node.data + " In pre Order ");
		traversal(node.left);
		System.out.println(node.data + " In In Order ");
		traversal(node.right);
		System.out.println(node.data + " In Post Order ");
		
		
	}
