//https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1#
class Intersect
{
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2)
	{
         int len1 = 0;
         Node node1 = head1;
         while(node1 != null){
             len1++;
             node1 = node1.next;
         }
         int len2 = 0;
         node1 = head2;
         while(node1 != null){
             len2++;
             node1 = node1.next;
         }
         
         int diff = len1 - len2;
         if(diff < 0){
             diff = -diff;
         }
         Node node2 = head2;
         node1 = head1;
         if(len1 > len2){
            node1 = head1;
            while(diff-->0){
                node1 = node1.next;
            }
            
         }else{
             node2 = head2;
             while(diff-->0){
                node2 = node2.next;
             }
         }
         while(node1 != node2){
             node1 = node1.next;
             node2 = node2.next;
         }
         return node1.data;
	}
}
