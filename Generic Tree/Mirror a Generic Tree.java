// Always have faith in recusrion

// Jai Ho recursion Baba ki

public static void mirrorGenericTree(Node node) {
		for(Node child : node.children) {
			mirrorGenericTree(child);
		}
		Collections.reverse(node.children);
	}
