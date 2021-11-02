package question6_7;

import question6_1.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flatten(root);
        printTree(root);
    }

    public static void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur != null) {
            if(cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                while(pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
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
