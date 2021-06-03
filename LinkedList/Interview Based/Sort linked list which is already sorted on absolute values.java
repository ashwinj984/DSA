//https://www.geeksforgeeks.org/sort-linked-list-already-sorted-absolute-values/

class GfG
{
	Node sortedList(Node head)
	{
		Node prev = head;
		Node curr = head.next;
		while(curr != null){
		    if(prev.data > curr.data){
		        prev.next  = curr.next;
		        curr.next = head;
		        head = curr;
		        curr = prev;
		    }else{
		        prev = curr;
		    }
		    curr = curr.next;
		}
		return head;
	}
}
