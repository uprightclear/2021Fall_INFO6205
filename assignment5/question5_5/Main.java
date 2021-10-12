package question5_5;

public class Main {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    //Time Complexity: o(n)
    //Space Complexity: o(n)
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2) return 0;
        //dp[x][y]:the max profit that you hold(1) or not hold(0) on day(x)
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }
}
