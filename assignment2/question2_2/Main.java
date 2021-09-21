package question2_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[][] example = {{0, 30}, {5, 10}, {15, 20}};
        int[][] example2 = {{0, 4}, {0, 20}, {5, 20}};
        System.out.println(meetingRooms(example));
        System.out.println(meetingRooms(example2));
    }

    //Time Complexity: o(nlogn) (sorting)
    //Space Complexity: o(n)
    public static int meetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        //default: minHeap
        PriorityQueue<Integer> tmp = new PriorityQueue<Integer>();
        tmp.add(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= tmp.peek()) {
                tmp.poll();
            }
            tmp.add(intervals[i][1]);
        }

        return tmp.size();
    }

}
