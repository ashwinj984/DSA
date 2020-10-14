public static void iterativePrePostInTraversal(Node node) {
		Stack<Pair> st = new Stack<>();
		Pair rtp = new Pair(node, 1);
		st.push(rtp);
		String pre = "";
		String in = "";
		String post = "";
		while (st.size() > 0) {
			Pair top = st.peek();

			if (top.state == 1) {
				top.state++;
				
				pre += top.node.data + " ";
				if (top.node.left != null) {
					Pair lp = new Pair(top.node.left, 1);
					st.push(lp);
				}
			} else if (top.state == 2) {
				top.state++;
				in += top.node.data + " ";
				if (top.node.right != null) {
					Pair rp = new Pair(top.node.right, 1);
					st.push(rp);
				}
			} else {
				post += top.node.data + " ";
				st.pop();
			}
			
		}
		System.out.println(pre);
		System.out.println(in);
		System.out.println(post);
	}
