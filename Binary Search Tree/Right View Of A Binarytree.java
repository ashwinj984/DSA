import java.util.*;

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
// start logic==================================================
    public static ArrayList<Integer> rightView(TreeNode root) {
        if(root == null){
            return null;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        q.addLast(root);
        while(q.size() > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode rem = q.removeFirst();
                if(i == size - 1){
                    list.add(rem.val);
                }
                
                if(rem.left != null){
                    q.addLast(rem.left);
                }if(rem.right != null){
                    q.addLast(rem.right);
                }
            }
        }
        return list;

    }
// end logic =======================================================
    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        ArrayList<Integer> ans = rightView(root);
        for(Integer i : ans) System.out.println(i); 
    }

    public static void main(String[] args) {
        solve();
    }
}
