public static class BSTPair {
		boolean isBST;
		int min;
		int max;
	}

	public static BSTPair isBST(Node node) {
		if (node == null) {
			BSTPair bp = new BSTPair();
			bp.isBST = true;
			bp.min = Integer.MAX_VALUE;
			bp.max = Integer.MIN_VALUE;

			return bp;
		}

		BSTPair lb = isBST(node.left);
		BSTPair rb = isBST(node.right);

		BSTPair mp = new BSTPair();
		mp.isBST = lb.isBST && rb.isBST && (node.data >= lb.max && node.data <= rb.min);
		mp.max = Math.max(node.data, Math.max(lb.max, rb.max));
		mp.min = Math.min(node.data, Math.min(lb.min, rb.min));

		return mp;
	}
//Just the main Logic
