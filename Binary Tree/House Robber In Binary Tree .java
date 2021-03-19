// 1st method
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
    public static class housePair{
        int withrobbery = 0;
        int withoutrobbery = 0;
    }
    
    public static housePair HouseRobber_(TreeNode root){
        if(root == null){
            return new housePair();
        }
        
        housePair left = HouseRobber_(root.left);
        housePair right = HouseRobber_(root.right);
        
        housePair myans = new housePair();
        
        myans.withrobbery = left.withoutrobbery + root.val + right.withoutrobbery;
        
        myans.withoutrobbery = Math.max(left.withrobbery, left.withoutrobbery) + Math.max(right.withrobbery, right.withoutrobbery);
        
        return myans;
    }
    public static int HouseRobber(TreeNode root) {
        housePair res = HouseRobber_(root);
        
        return Math.max(res.withrobbery, res.withoutrobbery);
    }

    // input_Section_====================================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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
        System.out.println(HouseRobber(root));
    }

    public static void main(String[] args) {
        solve();
    }
}

/* 2nd method */

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
    
    public static int[] HouseRobber_(TreeNode root){
        if(root == null){
            return new int[2];
        }
        
        int[] left = HouseRobber_(root.left);
        int[] right = HouseRobber_(root.right);
        
        int[] myans = new int[2];
        
        myans[0] = left[1] + right[1] + root.val;
        myans[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return myans;
    }

    public static int HouseRobber(TreeNode root) {
        int[] myans = HouseRobber_(root);
        return Math.max(myans[0], myans[1]);
    }

    // input_Section_====================================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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
        System.out.println(HouseRobber(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
