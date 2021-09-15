package question2;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        int[][] example1 = {{0, 30}, {5, 10}, {15, 20}};
        int[][] example2 = {{5, 10}, {15, 20}};
        System.out.println(solution1(example1));
        System.out.println(solution2(example2));
    }

    //Brute Force
    //Time Complexity: o(n^2)
    //Space Complexity: o(1)
    public static boolean solution1(int[][] intervals) {
        int len = intervals.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (overlap(intervals[i], intervals[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean overlap(int[] interval1, int[] interval2) {
        return (interval1[0] >= interval2[0] && interval1[0] < interval2[1]) || (interval2[0] >= interval1[0] && interval2[0] < interval1[1]);
    }

    //Sorting (this solution uses the library's sort function, it can't meet the requirements of the assignment)
    //Time Complexity: o(nlogn)
    //Space Complexity: o(1)
    public static boolean solution2(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] interval1, int[] interval2){
                return interval1[0] - interval2[0];
            }
        });

        for(int i = 0; i < intervals.length - 1; i++){
            int preR = intervals[i][1], curL = intervals[i + 1][0];
            if(preR >= curL) return false;
        }
        return true;
    }
}
