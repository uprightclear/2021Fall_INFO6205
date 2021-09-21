package question2_7;

public class Main {
    public static void main(String[] args) {
        int[] example = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(example));
    }

    //Time Complexity: o(nlogn) (the worst conditon that we should iterate each element)
    //Space Complexity: o(1)
    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
