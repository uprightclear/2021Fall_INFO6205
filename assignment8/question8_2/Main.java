package question8_2;

public class Main {
    public static void main(String[] args) {
        System.out.println(validPath(3, new int[][] {{0, 1}, {1, 2}, {2, 0}}, 0, 2));
        System.out.println(validPath(6, new int[][] {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5));
    }

    public static int[] parent;
    public static boolean validPath(int n, int[][] edges, int start, int end) {
        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        for(int[] edge : edges) {
            int p1 = findParent(edge[0]);
            int p2 = findParent(edge[1]);
            if(p1 != p2) {
                parent[p1] = p2;
            }
        }
        return findParent(start) == findParent(end);
    }

    private static int findParent(int child) {
        return parent[child] == child ? child : (parent[child] = findParent(parent[child]));
    }
}
