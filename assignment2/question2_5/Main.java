package question2_5;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] example = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(findRange(example, 8)));
    }

    //Time Complexity: o(logn)
    //Space Complexity: o(1)
    public static int[] findRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }

        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition == -1) return new int[]{-1, -1};
        int lastPosition = findLastPosition(nums, target);
        return new int[]{firstPosition, lastPosition};
    }

    private static int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        if (nums[left] == target) return left;
        return -1;
    }

    private static int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) right = mid - 1;
            else left = mid;
        }
        if (nums[left] == target) return left;
        return -1;
    }

}

//    //Time Complexity: o(logn)
//    //Space Complexity: o(1)
//    public static int[] findRange(int[] nums, int target) {
//        int index = binarySearch(nums, target);
//        if(index == -1) return new int[]{-1, -1};
//        int low = index - 1, high = index + 1;
//        while(low >= 0 &&nums[low] == target) low--;
//        while(high < nums.length && nums[high] == target) high++;
//        return new int[]{low + 1, high - 1};
//    }
//
//    public static int binarySearch(int[] nums, int target) {
//        int left = 0, right = nums.length - 1;
//        while(left <= right) {
//            int mid = (left + right) / 2;
//            if(nums[mid] == target) return mid;
//            else if(nums[mid] < target) left = mid + 1;
//            else right = mid - 1;
//        }
//        return -1;
//    }

