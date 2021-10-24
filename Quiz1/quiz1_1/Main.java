package quiz1_1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] example = {0, 1, 0, 3, 12};
        moveZeroes(example);
        System.out.println(Arrays.toString(example));
    }

    private static void moveZeroes(int[] nums) {
        int len = nums.length, left = 0, right = 0;
        while(right < len) {
            if(nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private static void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
