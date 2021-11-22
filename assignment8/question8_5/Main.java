package question8_5;

public class Main {
    public static void main(String[] args) {
        int[][] edges = new int[][] {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(countComponents(5, edges));
    }

    public static int countComponents(int n, int[][] edges) {
        int ans = 0;
        boolean[] used = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!used[i]){
                ans++;
                dfs(edges, used, i);
            }
        }
        return ans;
    }

    private static void dfs(int[][] edges, boolean[] used, int num) {
        if(used[num]) return;
        used[num] = true;
        for(int[] edge : edges) {
            for(int element : edge) {
                if(element == num) {
                    if(edge[0] == num) dfs(edges, used, edge[1]);
                    else dfs(edges, used, edge[0]);
                }
            }
        }
    }
}
