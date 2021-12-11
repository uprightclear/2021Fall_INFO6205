package LongestCommonSubstring;

public class Main {
    public static void main(String[] args) {
        String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";

        int m = X.length();
        int n = Y.length();

        System.out.println(LCSubStr(X.toCharArray(), Y.toCharArray(), m, n));
    }

    public static int LCSubStr(char X[], char Y[], int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        int result = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
                else dp[i][j] = 0;
            }
        }
        return result;
    }
}
