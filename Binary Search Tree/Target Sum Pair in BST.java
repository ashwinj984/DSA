   public static void travelAndprint(Node root, Node node, int tar) {
		if (node == null) {
			return;
		}
		travelAndprint(root, node.left, tar);

		int comp = tar - node.data;
		if (node.data < comp) {
			if (find(root, comp) == true) {
				System.out.println(node.data + " " + comp);
			}
		}
		travelAndprint(root,node.right,tar);
    }
		
	public static boolean find(Node node, int data) {
		// write your code here
		if (node == null) {
			return false;
		}
		if (data > node.data) {
			return find(node.right, data);
		} else if (data < node.data) {
			return find(node.left, data);
		} else {
			return true;
		}
	}
