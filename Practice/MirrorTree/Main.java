package MirrorTree;

public class Main {
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        /* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input tree is :");
        inOrder(root);
        System.out.println("");

        /* convert tree to its mirror */
        mirror(root);

        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of binary tree is : ");
        inOrder(root);
    }

    public static Node mirror(Node node) {
        if(node == null) return node;
        Node left = mirror(node.left);
        Node right = mirror(node.right);
        node.left = right;
        node.right = left;
        return node;
    }

    public static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
}
