private void foldhelper(Node node,int floor){
        if(node == null){
            return;
        }
        
       
        foldhelper(node.next,floor + 1);
        if(floor > size / 2){
            Node temp = pleft.next;
            pleft.next = node;
            node.next = temp;
            pleft  = temp;
        }
        if(floor == size / 2){
            tail = node;
            tail.next = null;
        }
        
    }
     Node pleft;
    public void fold() {
        pleft = head;
        foldhelper(head,0);
    }
    
    //recursive approach
