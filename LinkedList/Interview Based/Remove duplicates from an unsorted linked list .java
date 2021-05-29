//https://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1

class Solution
{
    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) 
    {
        HashSet<Integer> set = new HashSet<>();
        Node node = head;
        Node prev = null;
        while(node != null){
            if(set.contains(node.data)){
                prev.next = node.next;
                node = prev.next;
                continue;
            }
            set.add(node.data);
            prev = node;
            node = node.next;
        }
        return head;
    }
  
}
