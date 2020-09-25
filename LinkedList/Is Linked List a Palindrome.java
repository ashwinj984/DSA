  private boolean palindromeHelper(Node node){
        if(node == null){
            return true;
        }
        
        boolean k = palindromeHelper(node.next);
        
        if(k == false){
            return false;
        }        
        else if(pleft.data != node.data)
        {
            return false;
        }
        else{
            pleft = pleft.next;
            return true;
        }
    }
    Node pleft;

    public boolean IsPalindrome() {
        pleft = head;
     boolean k =  palindromeHelper(head);
     return k;
  }
  
  // you can also use a floor to optimize ,keeping a track of count and end at the mid point
  // I am not going to do that here
