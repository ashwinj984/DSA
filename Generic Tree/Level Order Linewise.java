public static void levelOrderLinewise(Node node){
	    Queue<Node> mq = new ArrayDeque<>();
	    Queue<Node> cq = new ArrayDeque<>();
	    
	    mq.add(node);
	    
	    while(mq.size() > 0){
	    	
	    	
	    	node = mq.remove();
	    	System.out.print(node.data + " ");
	    	for(Node child : node.children) {
	    		cq.add(child);
	    	}
	    	if(mq.size() == 0) {
	    		System.out.println();
	    		mq = cq;
	    		cq = new ArrayDeque<>();
	    	}
	    }
	}
