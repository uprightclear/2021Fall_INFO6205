package question7_5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<String> arr1 = Arrays.asList(new String[]{"un", "iq", "ue"});
        List<String> arr2 = Arrays.asList(new String[]{"aa", "bb"});
        System.out.println(maxLength(arr1));
        System.out.println(maxLength(arr2));
    }

    public static int maxLength(List<String> arr) {
        return dfs(arr, 0, "");
    }

    public static int dfs(List<String> arr, int pos, String res) {
        Set<Character> set = new HashSet<>();
        for(char c : res.toCharArray()) set.add(c);
        //judge whether all the characters in res is unique, if not return 0
        if(res.length() != set.size()) return 0;
        //if current res meets the requirement, then use the best to store its length
        int best = res.length();
        for(int i = pos; i < arr.size(); i++) {
            best = Math.max(best, dfs(arr, i + 1, res + arr.get(i)));
        }
        return best;
    }
}
