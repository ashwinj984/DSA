import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode midNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode s = head;
        ListNode f = head;
        while(f.next != null && f.next.next != null){
            f = f.next.next;
            s = s.next;
        }
        return s;
    }
    
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode forw = null;
        while(curr != null){
            forw = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = forw;
        }
        return prev;
    }
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode mid = midNode(head);
        ListNode nhead = mid.next;
        
        nhead = reverse(nhead);
        
        ListNode c1 = head;
        ListNode c2 = nhead;
        boolean res = true;
         while(c2 != null){
            if(c1.val != c2.val){
                res = false;
                break;
            }
            c1 = c1.next;
            c2 = c2.next;
         }
        nhead = reverse(nhead);
        mid.next = nhead;
        return res;
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

        System.out.println(isPalindrome(dummy.next));
    }
}
