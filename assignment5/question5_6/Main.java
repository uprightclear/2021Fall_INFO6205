package question5_6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] {1, 7, 3, 6, 5, 6}));
        System.out.println(pivotIndex(new int[] {1, 2, 3}));
        System.out.println(pivotIndex(new int[] {2, 1, -1}));
    }

    //Time Complexity: o(n)
    //Space Complexity: o(1)
    public static int pivotIndex(int[] nums) {
        int total = 0;
        for(int num : nums) total += num;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
