package question2_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] example = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(example, 9)));
        System.out.println(Arrays.toString(twoSum2(example, 9)));
    }

    //Brute Force
    //Time Complexity: o(n^2)
    //Space Complexity: o(1)
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] == target - nums[i]) return new int[]{i, j};
            }
        }
        return null;
    }

    //Hash Table
    //Time Complexity: o(n)
    //Space Complexity: o(n)
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if(map.containsKey(tmp)) return new int[] {map.get(tmp), i};
            map.put(nums[i], i);
        }
        return null;
    }
}
