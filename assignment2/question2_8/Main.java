package question2_8;

public class Main {
    public static void main(String[] args) {
        int[] example = {1, 2, 3, 3, 4, 5};
        System.out.println(findRepeatedNum(example));
    }

    //Time Complexity: o(logn)
    //Space Complexity: o(1)
    public static int findRepeatedNum(int[] nums) {
        int low = 1, high = nums.length - 1;
        int RepeatedNum = 0;

        while (low <= high) {
            int curr = (low + high) / 2;

            // Count how many numbers in 'nums' are less than or equal to 'cur'
            int count = 0;
            for (int num : nums) {
                if (num <= curr) count++;
            }

            if (count > curr) {
                RepeatedNum = curr;
                high = curr - 1;
            } else low = curr + 1;
        }
        return RepeatedNum;
    }
}
