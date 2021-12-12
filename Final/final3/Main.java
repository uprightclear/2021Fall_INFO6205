package final3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int[] arr1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(maxSteps(arr));
        System.out.println(maxSteps(arr1));
    }

    public static int maxSteps(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(j + arr[j] >= i) dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[n - 1] == n ? -1 : dp[n - 1];
    }
}
