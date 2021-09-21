package question2_4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] example = {3, 2, 3, 6, 7, 2, 3};
        System.out.println(findElement(example));
    }

    //Time Complexity: o(n)
    //Space Complexity: o(1) (without concerning of the space of the output)
    public static List<Integer> findElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int candidate1 = nums[0], count1 = 0;
        int candidate2 = nums[0], count2 = 0;

        for(int num : nums) {
            if(num == candidate1) {
                count1++;
                continue;
            }
            if(num == candidate2) {
                count2++;
                continue;
            }
            if(count1 == 0) {
                candidate1 = num;
                count1 = 1;
                continue;
            }
            if(count2 == 0) {
                candidate2 = num;
                count2 = 1;
                continue;
            }

            count1--;
            count2--;
        }

        count1 = 0;
        count2 = 0;
        for(int num : nums) {
            if(candidate1 == num) count1++;
            if(candidate2 == num) count2++;
        }

        if(count1 > nums.length / 3) ans.add(candidate1);
        if(count2 > nums.length / 3) ans.add(candidate2);

        return ans;
    }

}
