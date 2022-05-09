//https://practice.geeksforgeeks.org/problems/subtraction-in-linked-list/1/
class Solution
{
    
    static Node reverse(Node node){
        Node prev = null;
        Node curr = node;
        Node forw = null;
        while(curr != null){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr =  forw;
        }
        return prev;
    }
    static Node subLinkedList(Node l1, Node l2)
    {
        Node result = new Node(-1);
        Node ans = result;
        int flag = 0;
        Node list1 = l1;
        Node list2 = l2;
        while(list1 != null && list1.data == 0){
            list1 = list1.next;
        }
        l1 = list1;
        
        while(list2 != null && list2.data == 0){
            list2 = list2.next;
        }
        l2 = list2;
        
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        
        // to check which list is greater or smaller
        while(list1 != null && list2 != null){
            if(list1.data == list2.data){
                list1 = list1.next;
                list2 = list2.next;
                continue;
            }
                list1 = list1.next;
                list2 = list2.next;
                flag = 1;
        }
        if(list1 == null && list2 != null){
            Node node = l2;
            l2 = l1;
            l1 = node;
        }
        if(list1 == null && list2 == null){
            if(flag == 0){
                return new Node(0);
            }
            list1 = l1;
            list2 = l2;
            while(list1 != null && list2 != null){
                if(list1.data > list2.data){
                    break;
                }
                if(list2.data > list1.data){
                    Node node = l2;
                    l2 = l1;
                    l1 = node;
                    break;
                }
                list1 = list1.next;
                list2 = list2.next;
            }
        }
        Node one = reverse(l1);
        Node two = reverse(l2);
        Node temp1 = one;
        Node temp2 = two;
        int num;
        while(temp1 != null && temp2 != null){
            if(temp1.data >= temp2.data){
                num = temp1.data - temp2.data;
                ans.next = new Node(num);
                ans = ans.next;
            }else{
                num = temp1.data - temp2.data + 10;
                ans.next = new Node(num);
                ans = ans.next;
                temp1.next.data = temp1.next.data - 1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while(temp1 != null){
            if(temp1.data < 0){
                num = temp1.data + 10;
                ans.next = new Node(num);
                ans = ans.next;
                temp1.next.data = temp1.next.data - 1;
            }else{
                ans.next = new Node(temp1.data);
                ans = ans.next;
            }
            temp1 = temp1.next;
        }
        Node actual = reverse(result.next);
        Node ptr = actual;
        while(ptr.data == 0){
            ptr = ptr.next;
        }
        actual = ptr;
        return actual;
    }
}
