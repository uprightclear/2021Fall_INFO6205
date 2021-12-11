package GetBalancedTreeFromBST;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.left.left = new Node(7);
        root.left.left.left = new Node(6);
        root.left.left.left.left = new Node(5);

        root = buildTree(root);
        System.out.println("Preorder traversal of balanced BST is :");
        preOrder(root);
    }

    public static Node buildTree(Node root) {
        List<Node> nodes = new ArrayList<>();
        storeBSTNodes(root, nodes);
        int n = nodes.size();
        return helper(nodes, 0, n - 1);
    }

    public static Node helper(List<Node> nodes, int start, int end) {
        if(start > end) return null;
        int mid = (start + end) / 2;
        Node node = nodes.get(mid);
        node.left = helper(nodes, start, mid - 1);
        node.right = helper(nodes, mid + 1, end);
        return node;
    }

    public static void storeBSTNodes(Node root, List<Node> nodes) {
        if(root == null) return;
        storeBSTNodes(root.left, nodes);
        nodes.add(root);
        storeBSTNodes(root.right, nodes);
    }

    public static void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}
