class GfG
{
    Node flatten(Node root)
    {
        if(root == null || root.next == null){
            return root;
        }
	    Node node = root;
	    node.next = flatten(node.next);
	    node = merge(node, node.next);
	    return node;
    }
    
    Node merge(Node a, Node b){
        if(a == null){
            return a;
        }
        if(b == null){
            return b;
        }
        
        Node result;
        if(a.data < b.data){
            result = a;
            result.bottom = merge(a.bottom, b);
        }else{
            result = b;
            result.bottom = merge(a, b.bottom);
        }
        result.next = null;
        return result;
    }
}
// USED Merge two sorted list concept as well as merge sort list
