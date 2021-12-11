package LeavesSameLevel;

public class Main {
    public static void main(String args[]) {
        // Let us create the tree as shown in the example
        Node root = new Node(12);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(9);
        root.left.left.left = new Node(1);
        root.left.right.left = new Node(1);
        //root.left.right.left.right = new Node(1);
        if (check(root, 0))
            System.out.println("Leaves are at same level");
        else
            System.out.println("Leaves are not at same level");
    }

    public static int leafLevel = 0;
    public static boolean check(Node node, int level) {
        if(node == null) return true;
        if(node.left == null && node.right == null) {
            if(leafLevel == 0) {
                leafLevel = level;
                return true;
            }
            return level == leafLevel;
        }
        return check(node.left, level + 1) && check(node.right, level + 1);
    }
}
