public static void LevelOrder(Node node) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(node);
		while(q.size() > 0) {
			node = q.remove();
			System.out.println(node.data + " ");
			for(Node child:node.children) {
				q.add(child);
			}
		}
		System.out.println(".");
	}
