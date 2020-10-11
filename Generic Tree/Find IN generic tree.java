 public static boolean find(Node node, int data) {
    // write your code here
    if(node.data == data){
        return true;
    }
    for(Node child:node.children){
        boolean k = find(child,data);
        if(k) 
            return true;
            
    }
   return false;
    
  }
