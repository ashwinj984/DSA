 public static int sizehelper(Node node){
      int size = 0;
      for(Node child : node.children){
        size += sizehelper(child);
        
      }
      size++;
      
      return size;
  }

  public static int size(Node node){
    
    int size = sizehelper(node);
    
    return size; 
  }
  //have faith in recursion
  // I have asked recursion to find the size of each of it children and that's what it it doing
  // Recursion is all about solving lower problems to get hogher answers.
  // And i succeeded 
  //Well It wasn't a big deal
