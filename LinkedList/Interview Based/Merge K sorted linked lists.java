class Solution{ 

Node mergeKList(Node[]arr,int K)
    {
        for(int i = 0; i < arr.length; i++){
            Node node = mergeSort(arr[i]);
            arr[i] = node;
//          display(arr[i]);
        }
        for(int i = 1; i < arr.length; i++){
            arr[0] = mergeTwoLinkedList(arr[0], arr[i]);
        }
        return arr[0];
        
    }
    void display(Node node1){
        Node node = node1;
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
    Node mergeSort(Node head)
    {
        if(head.next == null){
            return head;
        }
        int len = length(head);
        Node node = head;
        for(int i =1; i < len / 2; i++){
            node = node.next;
        }
        Node forw = node.next;
        node.next = null;
        Node list1 = mergeSort(head);
        Node list2 = mergeSort(forw);
        
        Node list3 = mergeTwoLinkedList(list1, list2);
        return list3;
    }
    
    Node mergeTwoLinkedList(Node node1, Node node2){
        Node node3 = new Node(0);
        Node dummy = node3;
        while(node1 != null && node2 != null){
            if(node1.data < node2.data){
                dummy.next = new Node(node1.data);
                node1 = node1.next;
            }else{
                dummy.next = new Node(node2.data);
                node2 = node2.next;
            }
            dummy = dummy.next;
        }
        
        while(node1 != null){
            dummy.next = new Node(node1.data);
            node1 = node1.next;
            dummy = dummy.next;
        }
        while(node2 != null){
            dummy.next = new Node(node2.data);
            node2 = node2.next;
            dummy = dummy.next;
        }
        
        return node3.next;        
    }
    
    int length(Node head){
        int len = 0;
        Node node = head;
        while(node != null){
            len++;
            node = node.next;
        }
        return len;
    }
}
