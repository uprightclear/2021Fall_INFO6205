package FindKthSmallest;

public class Main {
    public static void main(String[] args) {
        // Your Java Code
        /* Constructed binary tree is
             4
            / \
           2   7
          / \ / \
         1  3 6 10 */

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(10);

        KthLargest(root, 5);
        System.out.println("Finding K-th smallest Node in BST : " + ans.data);
    }
    public static int count = 0;
    public static Node ans = new Node(-1);
    public static void KthLargest(Node node, int k) {
        if(node == null) return;
        KthLargest(node.left, k);

        count++;
        if(count == k) {
            ans = node;
            return;
        }

        KthLargest(node.right, k);
    }
}

