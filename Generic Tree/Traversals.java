public static void traversals(Node node){
		 //Area when you enter in the Node
	        System.out.println("Node Pre "+ node.data);
	        for(Node child : node.children){
	        	//area when going through edge
	            System.out.println("Edge Pre "+ node.data +"--"+ child.data);
	            traversals(child);
	            //area when going out of the edge
	            System.out.println("Edge Post "+ node.data +"--"+ child.data);
	        }
	        //area coming oue of thr node or recursion
	        System.out.println("Node Post "  + node.data);
	  }
