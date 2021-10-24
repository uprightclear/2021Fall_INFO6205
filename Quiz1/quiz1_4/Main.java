package quiz1_4;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        printNode(root);
    }

    public static void printNode(TreeNode root) {
        int layer = 1;
        int count = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            count = layer;
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                if(count-- > 0) {
                    System.out.print(node.val + " ");
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            System.out.println();
            layer++;
        }
    }
}
