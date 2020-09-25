private void reversePRHelper(Node node){
      if(node == null){
          return;
      }
        
      reversePRHelper(node.next);
      if(node == tail){
          //nothing to do
      }
      else{
          node.next.next = node;
          
      }
    }

    public void reversePR(){
      reversePRHelper(head);
      head.next = null;
      Node temp = head;
      head = tail;
      tail = temp;
      //System.out.println();
    }
