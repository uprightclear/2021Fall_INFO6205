package quiz1_2;

public class Main {
    public static void main(String[] args) {
        int[] example = {3, 0, 1};
        System.out.println(findMissing(example));
    }

    private static int findMissing(int[] nums) {
        int len = nums.length;
        int sum = 0;
        sum = (1 + len) * len / 2;
        for(int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
