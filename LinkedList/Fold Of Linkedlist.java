import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode midNode(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
        
        ListNode s = node;
        ListNode f = node;
        
        while(f.next != null && f.next.next != null){
            s = s.next;
            f = f.next.next;
        }
        
        return s;
    }
    
    public static ListNode reverse(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
        
        ListNode prev = null;
        ListNode curr = node;
        ListNode forw = null;
        while(curr != null){
            forw = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = forw;
        }
        
        return prev;
    }

    public static void fold(ListNode head) {
     ListNode mid = midNode(head);
     
     ListNode nhead = mid.next;
     
     mid.next = null;
     
     ListNode node = reverse(nhead);
     
     ListNode c1 = head;
     ListNode c2 = node;
     ListNode f1 = null;
     ListNode f2 = null;
     
     while(c2 != null){
         // Backup
        f1 = c1.next;
        f2 = c2.next;
        // Link
        c1.next = c2;
        c2.next = f1;
        
        // Move
        
        c1 = f1;
        c2  = f2;
     }
     
     
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        fold(head);
        printList(head);
    }
}
