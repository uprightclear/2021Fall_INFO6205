package question8_7;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));
    }

    static int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0, orange = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }else if(grid[i][j] == 1) orange++;
            }
        }

        if(orange == 0) return 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for(int i = 0; i < size; i++) {
                int[] rot = queue.poll();
                int x = rot[0];
                int y = rot[1];
                for(int k = 0; k < 4; k++) {
                    int newx = x + directions[k][0];
                    int newy = y + directions[k][1];
                    if(newx < 0 || newx >= m || newy < 0 || newy >= n || grid[newx][newy] != 1) continue;
                    grid[newx][newy] = 2;
                    orange--;
                    queue.offer(new int[]{newx, newy});
                }
            }
        }

        if(orange > 0) return -1;
        return res - 1;
    }
}
