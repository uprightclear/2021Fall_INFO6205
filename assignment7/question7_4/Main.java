package question7_4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(findWords(board, words));
    }

    private static int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private static int m;
    private static int n;
    private static String word;
    private static Set<String> res;

    public static List<String> findWords(char[][] board, String[] words) {
        res = new HashSet<>();
        m = board.length;
        if (m == 0) {
            return new ArrayList<String>(res);
        }
        n = board[0].length;

        for(String word : words){
            boolean[][] marked = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(i, j, word, marked, board, 0);
                }
            }
        }
        return new ArrayList<String>(res);
    }

    private static void dfs(int i, int j, String word, boolean[][] marked, char[][] board, int start) {
        if (start == word.length() - 1) {
            if(board[i][j] == word.charAt(start)){
                res.add(word);
                return;
            }
        }
        if (board[i][j] == word.charAt(start)) {
            marked[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (inArea(newX, newY) && !marked[newX][newY]) {
                    dfs(newX, newY, word, marked, board, start + 1);
                }
            }
            marked[i][j] = false;
        }
        return;
    }

    private static boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
