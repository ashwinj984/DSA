// Recursion is great
// have faith and it will do work for you

public static boolean areMirror(Node n1, Node n2) {
		if (n1.children.size() != n2.children.size()) {
			return false;
		}

		for (int i = 0; i < n1.children.size(); i++) {
			Node c1 = n1.children.get(n1.children.size() - i - 1);
			Node c2 = n2.children.get(i);

			if (areMirror(c1, c2) == false) {
				return false;
			}

		}
		return true;

	}
