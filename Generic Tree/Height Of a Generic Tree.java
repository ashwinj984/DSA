public static int height(Node node) {
    int ht = -1;
    for(Node child : node.children){
        int ch = height(child);
        ht = Math.max(ht,ch);
    }
    ht+=1;
    return ht;
  }
  //Not too much impressive
  
