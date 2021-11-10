package question7_1;

public class Main {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "ABCCES"));
    }

    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] used;
    static int len;

    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        used = new boolean[m][n];
        len = word.length();
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(board, i, j, 1, word)) return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int x, int y, int depth, String word) {
        if(depth == len) return true;

        used[x][y] = true;
        char next = word.charAt(depth);

        for (int i = 0; i < 4; i++) {
            int newx = x + directions[i][0];
            int newy = y + directions[i][1];
            if(newx >= 0 && newx < board.length && newy >= 0 && newy < board[0].length && !used[newx][newy] && board[newx][newy] == next) {
                if(dfs(board, newx, newy, depth + 1, word)) return true;
            }
        }
        used[x][y] = false;
        return false;
    }
}
