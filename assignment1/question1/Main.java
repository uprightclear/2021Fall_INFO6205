package question1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] example = {2,0,2,1,1,0};
        sortColors(example);
        System.out.println(Arrays.toString(example));
    }

    //Time Complexity: o(n)
    //Space Complexity: o(1)
    public static void sortColors(int[] nums){
        int high = nums.length - 1;
        int low = 0, mid = 0, pivot = 1;
        while(mid <= high){
            if(nums[mid] < pivot){
                swap(nums, mid, low);
                low++;
                mid++;
            }else if(nums[mid] > pivot){
                swap(nums, mid, high);
                high--;
            }else{
                mid++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
