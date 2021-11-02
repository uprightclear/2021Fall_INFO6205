package question6_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        TreeNode ans = mergeTrees(root, root2);
        printTree(ans);
    }

    public static TreeNode mergeTrees(TreeNode root, TreeNode root2) {
        if(root == null) {
            return root2;
        }
        if(root2 == null) {
            return root;
        }
        root.val += root2.val;
        root.left = mergeTrees(root.left, root2.left);
        root.right = mergeTrees(root.right, root2.right);
        return root;
    }

    public static void printTree(TreeNode root) {
        //List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                System.out.print(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            System.out.println();
        }
    }
}
