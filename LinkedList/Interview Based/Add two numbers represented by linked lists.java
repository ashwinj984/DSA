//https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
 
    while (l1 != null)
    {
        stack1.add(l1.data);
        l1 = l1.next;
    }
 
    while (l2 != null)
    {
        stack2.add(l2.data);
        l2 = l2.next;
    }
 
    int carry = 0;
    Node result = null;
 
    while (!stack1.isEmpty() ||
           !stack2.isEmpty())
    {
        int a = 0, b = 0;
 
        if (!stack1.isEmpty())
        {
            a = stack1.pop();
        }
 
        if (!stack2.isEmpty())
        {
            b = stack2.pop();
        }
 
        int total = a + b + carry;
 
        Node temp = new Node(total % 10);
        carry = total / 10;
 
        if (result == null)
        {
            result = temp;
        }
        else
        {
            temp.next = result;
            result = temp;
        }
    }
 
    if (carry != 0)
    {
        Node temp = new Node(carry);
        temp.next = result;
        result = temp;
    }
    return result;
