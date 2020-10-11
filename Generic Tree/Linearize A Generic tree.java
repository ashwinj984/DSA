  public static void linearize(Node node) {
		for(Node child: node.children) {
			linearize(child);
		}
		
		while(node.children.size() > 1) {
			Node lc = node.children.remove(node.children.size()  - 1);
			Node sc = node.children.get(node.children.size()  - 1);
			Node sltail = getTail(sc);
			sltail.children.add(lc);
		}
		
	}
	//This function is written to find what is the last node of the children
	// So as to connect it to the pre removed node
	private static Node getTail(Node node) {
		while(node.children.size() == 1) {
			node = node.children.get(0);
		}
		return node;
	}
