package question4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] example = {-4, 1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(example)));
    }

    //Time Complexity: o(n)
    //Space Complexity: o(1) without concerning of the output array,
    public static int[] sortedSquares(int[] nums){
        int len = nums.length;
        int ans[] = new int[len];
        for(int i = 0, j = len - 1, pos = len - 1; i <= j; ){
            if(nums[i] * nums[i] > nums[j] * nums[j]){
                ans[pos] = nums[i] * nums[i];
                i++;
            }else{
                ans[pos] = nums[j] * nums[j];
                j--;
            }
            pos--;
        }
        return ans;
    }
}
