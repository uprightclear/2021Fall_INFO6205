package final2;

public class Main {
    public static void main(String args[]) {
		/* The constructed binary tree is
			1
		   / \
		  2	  3
		   \ /
		   4 5
		*/
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.left.right = new Node(5);

        if (isFoldable(root))
            System.out.println("This tree is foldable");
        else
            System.out.println("This tree is not foldable");
    }

    public static boolean isFoldable(Node node) {
        boolean res;
        if (node == null) return true;
        mirror(node.left);
        res = isStructSame(node.left, node.right);
        mirror(node.left);
        return res;
    }

    public static boolean isStructSame(Node a, Node b) {
        if(a == null && b== null) return true;
        if(a != null && b != null && isStructSame(a.left, b.left) && isStructSame(a.right, b.right)) return true;
        return false;
    }

    public static Node mirror(Node node) {
        if(node == null) return node;
        Node left = mirror(node.left);
        Node right = mirror(node.right);
        node.left = right;
        node.right = left;
        return node;
    }
}
