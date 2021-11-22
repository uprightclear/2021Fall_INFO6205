package question8_6;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {1, 0}};
        int[][] grid1 = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid));
        System.out.println(shortestPathBinaryMatrix(grid1));
    }

    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int ans = 1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        if(grid[0][0] == 1) return -1;
        visited[0][0] = true;
        queue.offer(new int[] {0, 0});

        while(!queue.isEmpty()) {
            for(int size = queue.size(); size > 0; size--) {
                int[] cur = queue.poll();
                if(cur[0] == n - 1 && cur[1] == n - 1) return ans;
                for(int i = 0; i < 8; i++) {
                    int newx = cur[0] + directions[i][0];
                    int newy = cur[1] + directions[i][1];
                    if(newx >= 0 && newx < n && newy >= 0 && newy < n && grid[newx][newy] == 0 && !visited[newx][newy]) {
                        visited[newx][newy] = true;
                        queue.offer(new int[] {newx, newy});
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
