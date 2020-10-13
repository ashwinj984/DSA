static int mSum = 0;
	static int mSumNode = 0;

	public static int nodeWithMaximumSubtreeSum(Node node) {
		int sum = 0;

		for (Node child : node.children) {
			int cstSum = nodeWithMaximumSubtreeSum(child);
			sum += cstSum;
		}
		sum += node.data;

		if (sum > mSum) {
			mSum = sum;
			mSumNode = node.data;
		}

		return sum;
	}
