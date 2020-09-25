//I am just writing the main logic 
// else you can understand by yourself
public void kReverse(int k) {
      LinkedList prev = null;
      
      while(this.size > 0){
          LinkedList curr = new LinkedList();
          if(this.size >= k){
              for(int i = 0; i < k; i++){
              int val = this.getFirst();
              this.removeFirst();
              curr.addFirst(val);
              }
          }
              else if(this.size<k){
                  int s = this.size(); // here don't use the loop till this.size() because this.size() is decreasing and due to that loop will not be able to run properly
                  for(int i = 0; i < s; i++){
                      int val = this.getFirst();
                      this.removeFirst();
                      curr.addLast(val);
                  }
              }
              if(prev == null){
                  prev = curr;
              }
              else {
                  prev.tail.next = curr.head;
                  prev.tail = curr.tail;
                  prev.size += curr.size;
              }
          }
      this.head = prev.head;
      this.tail = prev.tail;
      this.size = prev.size;
      
     
    }
  
