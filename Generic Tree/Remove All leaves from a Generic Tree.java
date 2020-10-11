public static void removeleaves(Node node) {
		for(int i = node.children.size() - 1; i>= 0; i--) {
			Node child = node.children.get(i);
			if(child.children.size() == 0) {
				node.children.remove(child);
			}
		}
		for(Node child: node.children) {
			removeleaves(child);
		}
	}
  //there are 3 very problematic things one has to keep in mind
  // you know where you can learn them from
