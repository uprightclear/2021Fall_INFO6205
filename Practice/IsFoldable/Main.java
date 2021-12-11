package IsFoldable;

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
            System.out.println("tree is foldable");
        else
            System.out.println("Tree is not foldable");
    }

    public static boolean isFoldable(Node node) {
        boolean res;

        /* base case */
        if (node == null) return true;

        /* convert left subtree to its mirror */
        mirror(node.left);

		/* Compare the structures of the right subtree and mirrored
		left subtree */
        res = isStructSame(node.left, node.right);

        /* Get the original tree back */
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
