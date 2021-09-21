package question2_3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    //Time Complexity: o(n + m) (n: length of nums1, m: length of nums2)
    //Space Complexity: o(n)
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int num1 : nums1){
            set.add(num1);
        }
        int[] ans = new int[set.size()];
        int index = 0;
        for(int num2 : nums2){
            if(set.contains(num2)){
                ans[index++] = num2;
                set.remove(num2);
            }
        }
        return Arrays.copyOf(ans, index);
    }
}
