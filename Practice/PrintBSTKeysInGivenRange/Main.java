package PrintBSTKeysInGivenRange;

public class Main {
    public static void main(String[] args) {
        int k1 = 10, k2 = 25;
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);

        Print(root, k1, k2);
    }

    public static void Print(Node node, int k1, int k2) {
        if (node == null)  return;
        if (k1 < node.data) Print(node.left, k1, k2);
        if (k1 <= node.data && k2 >= node.data) System.out.print(node.data + " ");
        Print(node.right, k1, k2);
    }
}