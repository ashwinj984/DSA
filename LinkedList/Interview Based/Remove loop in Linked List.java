//https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1#

// Floyd's cycle detection method


class Solution
{
    public static void removeLopp(Node loop, Node head){
        Node ptr1 = null;
        Node ptr2 = null;
        
        ptr1 = loop;
        ptr2 = loop;
        
        int k = 1;
        while(ptr2.next != ptr1){
            k++;
            ptr2 = ptr2.next;
        }
        
        ptr1 = head;
        ptr2 = head;
        for(int i = 0; i < k; i++){
            ptr2 = ptr2.next;
        }
        
        while(ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        while(ptr2.next != ptr1){
            ptr2 = ptr2.next;
        }
        ptr2.next = null;
        //printlist(head);
    }
    
     public static void printlist(Node node){
         while(node != null){
             System.out.print(node.data + " ");
             node = node.next;
         }
     }
    public static void detectAndRemoveLoop(Node node){
        Node slow = node;
        Node fast = node;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                removeLopp(slow, node);
            }
        }
    }
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
       detectAndRemoveLoop(head);
    }
}
