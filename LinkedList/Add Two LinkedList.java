 public static int addTwoLists(Node on, Node tn, int pio, int pit, LinkedList res){
      if(on == null && tn == null){
        return 0;
      }

      int carry = 0;
      int data = 0;
      if(pio > pit){
        carry = addTwoLists(on.next, tn, pio - 1, pit, res);
        data = carry + on.data;
      } else if(pio < pit){
        carry = addTwoLists(on, tn.next, pio, pit - 1, res);
        data = carry + tn.data;
      } else {
        carry = addTwoLists(on.next, tn.next, pio - 1, pit - 1, res);
        data = carry + on.data + tn.data;
      }

      carry = data / 10;
      data = data % 10;

      res.addFirst(data);
      return carry;
    }

    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
      LinkedList res = new LinkedList();

      int carry = addTwoLists(one.head, two.head, one.size, two.size, res);
      if(carry > 0){
        res.addFirst(carry);
      }

      return res;
    }
    //P.S.
    //Do not  use reversal
    //Do not use conversion in array
