package question6_2;

import question6_1.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        System.out.println(sameLeaf(root, root2));

    }

    public static boolean sameLeaf(TreeNode a, TreeNode b) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs(a, l1);
        dfs(b, l2);
        if(l1.size() == l2.size()) {
            for(int i = 0; i < l1.size(); i++) {
                if(!l1.get(i).equals(l2.get(i))) return false;
            }
            return true;
        }
        return false;
    }

    public static void dfs(TreeNode root, List<Integer> l) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            l.add(root.val);
            return;
        }
        dfs(root.left, l);
        dfs(root.right, l);
    }
}
