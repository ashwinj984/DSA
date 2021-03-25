import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int idx;
    
    private static TreeNode constructor(int[] preorder, int lr, int rr){
        if(idx <= -1 || preorder[idx] < lr || preorder[idx] > rr){
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[idx--]);
        
        node.right = constructor(preorder, node.val, rr);
        node.left = constructor(preorder, lr, node.val);
        
        return node;
    }
    public static TreeNode bstFromPostorder(int[] preorder) {
        int n = preorder.length;
        idx = n - 1;
        int lr = -(int) 1e9 - 1;
        int rr = (int) 1e9 + 1;
        
        return constructor(preorder, lr, rr);
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = bstFromPostorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
