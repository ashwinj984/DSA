class Solution {
    ArrayList<Integer> findSum(int a[], int b[]) {
        Node one = new Node(-1);
        Node two = new Node(-2);
        Node curr = one;
        for(int i = 0; i < a.length; i++){
            curr.next = new Node(a[i]);
            curr = curr.next;
        }
        curr.next = null;
        one = one.next;
        Node nn = two;
        for(int i = 0; i < b.length; i++){
            nn.next = new Node(b[i]);
            nn = nn.next;
        }
        nn.next = null;
        two = two.next;

        one = reverse(one);
        two = reverse(two);
        Node ptr = new Node(-1);
        Node n3 = ptr;
        int carry = 0;
        while(one != null && two != null){
            int sum = one.data + two.data + carry;
            int val = sum % 10;
            Node node = new Node(val);
            carry = sum/10;
            n3.next = node;
            n3 = n3.next;
            one = one.next;
            two = two.next;
        }
        
        if(one != null){
            while(one != null){
                int sum = carry + one.data;
                Node node = new Node(sum % 10);
                carry = sum/10;
                n3.next = node;
                n3 = n3.next;
                one = one.next;
            }
        }else if(two != null){
            while(two != null){
                int sum = carry + two.data;
                Node node = new Node(sum % 10);
                carry = sum / 10;
                n3.next = node;
                n3 = n3.next;
                two = two.next;
            }
        }
        if(carry != 0){
            Node node = new Node(carry);
            n3.next = node;
            n3 = n3.next;
        }
        n3.next = null;
        ptr = ptr.next;
        ptr = reverse(ptr);
        ArrayList<Integer> ans = new ArrayList<>();
        while(ptr != null){
            ans.add(ptr.data);
            ptr = ptr.next;
        }
        return ans;
    }
    
    Node reverse(Node node){
        Node prev = null;
        Node curr = node;
        Node forw = null;
        while(curr != null){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }
}

class Node{
    int data;
    Node next;
    Node(int x){
        this.data = x;
    }
}
