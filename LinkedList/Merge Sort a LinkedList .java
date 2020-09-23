//this is a function of mergind=g two sorted arrays into a merge linked list
public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
      LinkedList ml = new LinkedList();

      Node one = l1.head;
      Node two = l2.head;
      while (one != null && two != null) {
        if (one.data < two.data) {
          ml.addLast(one.data);
          one = one.next;
        } else {
          ml.addLast(two.data);
          two = two.next;
        }
      }

      while (one != null) {
        ml.addLast(one.data);
        one = one.next;
      }

      while (two != null) {
        ml.addLast(two.data);
        two = two.next;
      }

      return ml;
    }
    // to find the mid node
    public static Node midNode(Node head,Node tail){
        Node f = head;
      Node s = head;

      while (f != tail && f.next != tail) {
        f = f.next.next;
        s = s.next;
      }

      return s;
    }
`// actual logic used
    public static LinkedList mergeSort(Node head, Node tail){
        if(head == tail){
            LinkedList an = new LinkedList();
            an.addLast(head.data);
            return an;
        }
        Node mid =midNode(head,tail);
        LinkedList fsh = mergeSort(head,mid);// go and find the sorted LinkedList of firt half
        LinkedList ssh = mergeSort(mid.next,tail);//go an find the sorted LinkedList of second half
        LinkedList c1 = mergeTwoSortedLists(fsh,ssh);//Merge two lists
        return c1;
    }
  }
