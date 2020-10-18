// Is balanced tree using Pair
	public static class isBal1 {
		int ht;
		boolean isbalance;

	}

	public static isBal1 isBal11(Node node) {
		if (node == null) {
			isBal1 bp = new isBal1();
			bp.ht = 0;
			bp.isbalance = true;
			return bp;
		}

		isBal1 lp = isBal11(node.left);
		isBal1 rp = isBal11(node.right);

		isBal1 mp = new isBal1();
		mp.ht = Math.max(lp.ht, rp.ht) + 1;
		mp.isbalance = lp.isbalance && rp.isbalance && (Math.abs(lp.ht - rp.ht) <= 1);

		return mp;
	}
