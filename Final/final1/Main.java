package final1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<Integer, Integer> map = new HashMap<>();
    public static int[] in;
    public static int[] level;
    public static void main(String[] args) {
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        int[] levelorder = {1, 2, 3, 4, 5, 6, 7};
        Node root = buildTree(inorder, levelorder);
        inorderPrint(root);
    }

    public static Node buildTree(int[] inorder, int[] levelorder) {
        int n = inorder.length;
        in = inorder;
        level = levelorder;
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, 0, n - 1);

    }

    public static Node helper(int levelorder_left, int inorder_left, int inorder_right) {
        if(inorder_left > inorder_right) return null;
        int levelorder_root = levelorder_left;
        int inorder_root = map.get(level[levelorder_root]);
        Node root = new Node(level[levelorder_root]);
        int size_left = inorder_root - inorder_left;
        root.left = helper(levelorder_left * 2 + 1, inorder_left, inorder_root - 1);
        root.right = helper(levelorder_left * 2 + 2, inorder_root + 1, inorder_right);
        return root;
    }

    public static void inorderPrint(Node node) {
        if(node == null) return;
        inorderPrint(node.left);
        System.out.print(node.value + " ");
        inorderPrint(node.right);
    }
}

