public static int diameter1(Node node) {
		
		if(node == null) {
			return null;
		}
		
		int ld = diameter1(node.left);
		int rd = diameter1(node.right);
		int f = height(node.left) + height(node.right) + 2;
		
		int dia = Math.max(f, Math.max(ld, rd));
		return dia;
	}
  
  //recursion is the best but it is not efficient all the time
