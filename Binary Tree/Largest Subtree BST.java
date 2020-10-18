// Largest Subtree BST
	public static class BSTPair1 {
		boolean isBST;
		int min;
		int max;
		Node root;
		int size;
	}

	public static BSTPair1 isBST1(Node node) {
		if (node == null) {
			BSTPair1 bp = new BSTPair1();
			bp.isBST = true;
			bp.min = Integer.MAX_VALUE;
			bp.max = Integer.MIN_VALUE;
			bp.root = null;
			bp.size = 0;
			return bp;
		}

		BSTPair1 lb = isBST1(node.left);
		BSTPair1 rb = isBST1(node.right);

		BSTPair1 mp = new BSTPair1();
		mp.isBST = lb.isBST && rb.isBST && (node.data >= lb.max && node.data <= rb.min);
		mp.max = Math.max(node.data, Math.max(lb.max, rb.max));
		mp.min = Math.min(node.data, Math.min(lb.min, rb.min));

		if (mp.isBST) {
			mp.root = node;
			mp.size = lb.size + rb.size + 1;
		} else if (lb.size > rb.size) {
			mp.root = lb.root;
			mp.size = lb.size;
		} else {
			mp.root = rb.root;
			mp.size = rb.size;
		}

		return mp;
	}
