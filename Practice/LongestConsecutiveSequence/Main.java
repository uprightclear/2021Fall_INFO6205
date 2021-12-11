package LongestConsecutiveSequence;

public class Main {
    public static void main(String args[]) {
        Node root = new Node(6);
        root.right = new Node(9);
        root.right.left = new Node(8);
        root.right.right = new Node(10);
        root.right.right.right = new Node(11);

        System.out.println(longestConsecutive(root));
    }
    public static int ans;
    public static int longestConsecutive(Node root) {
        if(root == null) return 0;
        ans = 0;
        helper(root, 0, root.data);
        return ans;
    }

    public static void helper(Node root, int curLength, int expected) {
        if(root == null) return;
        if(root.data == expected) curLength++;
        else curLength = 1;
        ans = Math.max(ans, curLength);
        helper(root.left, curLength, root.data + 1);
        helper(root.right, curLength, root.data + 1);
    }
}
