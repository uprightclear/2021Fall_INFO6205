package question6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] example = {3, 1, 2, 4, 6};
        System.out.println(Arrays.toString(moveArray(example)));
    }

    //Time Complexity: o(n)
    //Space Complexity: o(1)
    public static int[] moveArray(int[] nums){
        int len = nums.length;
        int p = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] % 2 == 0){
                swap(nums, i, p);
                p++;
            }
        }
        return nums;
    }

    private static void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
