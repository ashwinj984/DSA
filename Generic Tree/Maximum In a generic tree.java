public static int max(Node node) {
     int  max = node.data;
     for(Node child : node.children){
        int  max1 = max(child);
        max = Math.max(max,max1);
     }
     return max;
        
  }
  
  //not so much proud of myself
