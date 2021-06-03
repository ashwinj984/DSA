// https://practice.geeksforgeeks.org/problems/reorder-list/1

class gfg {
    Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node forw = null;
        while(curr != null){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }
    Node midNode(Node head){
        Node s = head;
        Node f = head;
        while(f != null && f.next != null && f.next.next != null){
            s = s.next;
            f = f.next.next;
        }
        Node forw = s.next;
        s.next = null;
        return forw;
    }
    Node reorderlist(Node head) {
        Node node = head;
        Node nextMid = midNode(head);
        Node revMid = reverse(nextMid);
        Node dummy = new Node(-1);
        Node ans = dummy;
        while(node != null && revMid != null){
            dummy.next = new Node(node.data);
            dummy = dummy.next;
            dummy.next = new Node(revMid.data);
            dummy = dummy.next;
            node = node.next;
            revMid = revMid.next;
        }
        if(node != null){
            dummy.next = new Node(node.data);
            node = node.next;
        }
        return ans.next;
    }
}
