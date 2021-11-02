package question6_8;

import question6_1.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> ans = new ArrayList<>();
        ans = verticalTraversal(root);

        for(List<Integer> list : ans) {
            for(int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


    public static PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
        if(a[0] != b[0]) return a[0] - b[0];
        if(a[1] != b[1]) return a[1] - b[1];
        return a[2] - b[2];
    });

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        int[] info = new int[]{0, 0, root.val};
        q.add(info);
        dfs(root, info);
        List<List<Integer>> ans = new ArrayList<>();
        while(!q.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int[] poll = q.peek();
            while(!q.isEmpty() && q.peek()[0] == poll[0]) tmp.add(q.poll()[2]);
            ans.add(tmp);
        }
        return ans;
    }

    public static void dfs(TreeNode node, int[] info){
        if(node.left != null){
            int[] linfo = new int[]{info[0] - 1, info[1] + 1, node.left.val};
            q.add(linfo);
            dfs(node.left, linfo);
        }

        if(node.right != null){
            int[] rinfo = new int[]{info[0] + 1, info[1] + 1, node.right.val};
            q.add(rinfo);
            dfs(node.right, rinfo);
        }
    }
}
