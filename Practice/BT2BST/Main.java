package BT2BST;

import java.util.Arrays;

public class Main {
    public static void main(String args[]) {

		/* Constructing tree given in the above figure
			10
			/ \
		   30 15
		   /   \
		  20	5 */
        Node root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.right.right = new Node(5);

        // convert Binary Tree to BST
        binaryTreeToBST(root);

        System.out.println("Following is Inorder Traversal of the converted BST: ");
        printInorder(root);

    }

    public static void binaryTreeToBST(Node root) {
        if(root == null) return;
        int n = countNodes(root);
        int[] arr = new int[n];
        storeInorder(root, arr);
        Arrays.sort(arr);
        index = 0;
        arrayToBST(arr, root);
    }

    public static void arrayToBST(int[] arr, Node root) {
        if (root == null) return;
        arrayToBST(arr, root.left);
        root.data = arr[index++];
        arrayToBST(arr, root.right);
    }

    public static int index = 0;
    public static void storeInorder(Node node, int inorder[]) {
        if (node == null) return;
        storeInorder(node.left, inorder);
        inorder[index++] = node.data;
        storeInorder(node.right, inorder);
    }

    public static int countNodes(Node root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void printInorder(Node node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
}
