package question8_4;

public class Main {
    public static void main(String[] args) {
        int[][] isConnected = new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] isConnected1 = new int[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(isConnected));
        System.out.println(findCircleNum(isConnected1));
    }

    public static int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        int ans = 0;

        for(int i = 0; i < len; i++) {
            if(!visited[i]) {
                dfs(isConnected, visited, len, i);
                ans++;
            }
        }
        return ans;
    }

    public static void dfs(int[][] isConnected, boolean[] visited, int len, int cur) {
        for(int i = 0; i < len; i++) {
            if(!visited[i] && isConnected[i][cur] == 1) {
                visited[i] = true;
                dfs(isConnected, visited, len, i);
            }
        }
    }
}
