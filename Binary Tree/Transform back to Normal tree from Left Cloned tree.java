public static Node transBackFromLeftClonedTree(Node node){
	    if(node == null){
	    	return null;
	    }
	    
	    Node lnn = transBackFromLeftClonedTree(node.left.left);
	    Node rnn = transBackFromLeftClonedTree(node.right);
	    
	    node.left = lnn;
	    return node;
	  }
