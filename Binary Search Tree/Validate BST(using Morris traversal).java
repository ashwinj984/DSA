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

	public static TreeNode getRightMostNode(TreeNode rightMost, TreeNode curr) {
		while(rightMost.right != null && rightMost.right != curr) {
			rightMost = rightMost.right;
		}
		return rightMost;
	}

	public static boolean isValidBST(TreeNode root) {
		TreeNode prev = null, curr = root;
		while (curr != null) {
			TreeNode leftNode = curr.left;
			if (leftNode == null) {
				if(prev != null && prev.val > curr.val) {
					return false;
				}
				prev = curr;
				curr = curr.right;
			} else {
				TreeNode rightMostNode = getRightMostNode(leftNode, curr);
				if(rightMostNode.right == null) {
					rightMostNode.right = curr;
					curr = curr.left;
				}else {
					if (prev != null && prev.val > curr.val) {
						return false;
					}
					rightMostNode.right = null;
					curr = curr.right;
				}
			}
		}
		return true;
	}

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
		System.out.println(isValidBST(root));
	}

	public static void main(String[] args) {
		solve();
	}
}
