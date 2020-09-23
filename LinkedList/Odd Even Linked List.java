 public void oddEven(){
      
      LinkedList odd = new LinkedList();
      LinkedList even = new LinkedList();
      while(this.size > 0){
          if(this.getFirst() % 2 == 0){
              even.addLast(this.getFirst());
          }else{
              odd.addLast(this.getFirst());
          }
          this.removeFirst();
      }
      if(odd.size > 0 && even.size > 0){
      odd.tail.next = even.head;
      this.head = odd.head;
      this.tail = even.tail;
      this.size = odd.size + even.size;
      }else if(even.size == 0){
        this.head = odd.head;
      this.tail = odd.tail;
      this.size = odd.size;
      }else if(odd.size == 0){
          this.head = even.head;
          this.tail = even.tail;
          this.size = even.size;
      }
    }
