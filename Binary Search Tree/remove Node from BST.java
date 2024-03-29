 public static Node remove(Node node, int data) {
	   if(data > node.data) {
		   node.right = remove(node.right,data);
	   }else if(data < node.data) {
		   node.left = remove(node.left,data);
	   }else {
		   //Main Work
		   if(node.left != null && node.right != null) {
			   int lmax = max(node.left);
			   node.data = lmax;
			   node.left = remove(node.left,lmax);
			   return node;
		   }else if(node.left !=null) {
			   return node.left;
		   }else if(node.right!=null) {
			   return node.right;
		   }else {
			   return null;
		   }
	   }
	   return node;
	  }
