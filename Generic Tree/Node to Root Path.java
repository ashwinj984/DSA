public static ArrayList<Integer> nodeToRootPath(Node node, int data){
		 if(node.data == data) {
			 ArrayList<Integer> kgf = new ArrayList<>();
			 kgf.add(node.data);
			 return kgf;
		 }
		 
		 for(Node child:node.children) {
			 ArrayList<Integer> kgf = nodeToRootPath(child, data);
			 if(kgf.size() > 0) {
				 kgf.add(node.data);
				 return kgf;
			 }
		 }
		 
		 return new ArrayList<>();
	 }
