https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1#
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        Node zero = new Node(-1);
        Node one = new Node(-1);
        Node two = new Node(-1);
        Node z = zero;
        Node o = one;
        Node t = two;
        Node curr = head;
        while(curr != null){
            if(curr.data == 0){
                z.next = new Node(curr.data);
                z = z.next;
                
            }else if(curr.data == 1){
                o.next = new Node(curr.data);
                o = o.next;
          
            }else if(curr.data == 2){
                t.next = new Node(curr.data);
                t = t.next;
               
            }
            
            curr = curr.next;
            
        }
        if(z == zero){
            o.next = two.next;
            return one.next;
        }else if(o == one){
            z.next = two.next;
            return zero.next;
        }else if(t == two){
            z.next = one.next;
            return zero.next;
        }
     //   display(zero, one, two);
        z.next = one.next;
        o.next = two.next;
        t.next = null;
        return zero.next;
    }
    
    static void display(Node zero, Node one, Node two){
        Node curr = zero.next;
        while(curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }
        curr = one.next;
        while(curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }
        curr = two.next;
        while(curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}


