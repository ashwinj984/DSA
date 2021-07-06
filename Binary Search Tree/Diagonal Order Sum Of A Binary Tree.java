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
  // shadow technique  
  
  
  // class for doubly linked list
  public static class Node{
      int data;
      Node prev = null;
      Node next = null;
      Node(int data){
          this.data = data;
      }
      
  }
  
  // dfs
  public static void dfs(TreeNode root, Node node){
      node.data += root.val;
      if(root.left != null){
          if(node.prev == null){
              Node newnode = new Node(0);
              node.prev = newnode;
              newnode.next = node;
          }
          dfs(root.left, node.prev);
          
      }
      if(root.right != null){
              dfs(root.right, node);
          }
  }

  public static ArrayList<Integer> diagonalOrderSum(TreeNode root) {
    Node nNode = new Node(0);
    dfs(root, nNode);
    ArrayList<Integer> list = new ArrayList<>();
    Node curr = nNode;
    while(curr != null){
        list.add(curr.data);
        curr = curr.prev;
    }
    return list;
   
  }

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

    ArrayList<Integer> ans = diagonalOrderSum(root);
    for (Integer j : ans)
      System.out.print(j + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}

