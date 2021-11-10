package question7_3;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "25525511135";
        List<String> result = restoreIpAddress(s);
        System.out.println(result);
    }

    private static int len;
    private static List<String> res = new ArrayList<>();
    private static Deque<String> path = new LinkedList<>();

    private static List<String> restoreIpAddress(String s) {
        len = s.length();
        //special judgement
        if(len > 12 || len < 4) return res;

        dfs(s, 0, 4);
        return res;
    }

    private static void dfs(String s, int begin, int remain) {
        if(begin == len) {
            if(remain == 0) {
                res.add(String.join(".", path));
                return;
            }
        }

        for(int i = begin; i < begin + 3; i++) {
            if(i >= len) break;
            //the current segment is too short
            if((remain - 1) * 3 + i + 1 < len) continue;
            //the current segment is too long
            if(remain - 1 + i + 1 > len) break;

            if(judgeIpSegment(s, begin, i)) {
                String cur = s.substring(begin, i + 1);
                path.addLast(cur);
                dfs(s, i + 1, remain - 1);
                path.removeLast();
            }
        }
    }

    private static boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if(len > 1 && s.charAt(left) == '0') return false;

        int sum = 0;
        while(left <= right) {
            sum = sum * 10 + s.charAt(left) - '0';
            left++;
        }

        return sum >= 0 && sum <= 255;
    }
}
