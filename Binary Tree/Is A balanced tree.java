// Is balanced tree Using recursion
	static boolean isBal = true;
	public static int isBal(Node node) {
		if(node == null) {
			return 0;
		}
		
		int lh = isBal(node.left);
		int rh = isBal(node.right);
		
		if(Math.abs(lh - rh) > 1)
			isBal = false;
		int ht = Math.max(lh, rh) + 1;
		return ht;
	}
