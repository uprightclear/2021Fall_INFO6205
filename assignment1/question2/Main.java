package question2;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        int[][] example = {{0, 30}, {5, 10}, {15, 20}};
        int[][] example2 = {{5, 10}, {15, 20}};
        System.out.println(meet(example2));
    }

    //Time Complexity: o(nlogn)
    //Space Complexity: o(logn)
    public static boolean meet(int[][] intervals){
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
