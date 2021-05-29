//1st Approach

class Solution
{
    static Node reverse(Node node){
        Node prev = null;
        Node forw = null;
        Node curr = node;
        while(curr != null){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }
    Node compute(Node head)
    {
        head = reverse(head);
        Node node = head;
        Node temp;
        Node max = head;
        while(node != null && node.next != null){
            if(node.next.data < max.data){
                temp = node.next;
                node.next = temp.next;
                temp = null;
            }else{
                node = node.next;
                max = node;
            }
        }
        return reverse(head);
    }
}
  
