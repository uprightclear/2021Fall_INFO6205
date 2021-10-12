package question5_7;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] example = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        int[][] ans = highFive(example);
        for(int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }

    //Time Complexity: o(nlogn)
    //Space Complexity: o(n)
    public static int[][] highFive(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            if (!map.containsKey(id))
                // use max heap here to store the score downward
                map.put(id, new PriorityQueue<>((a,b) -> b - a));
            map.get(id).add(score);
        }

        List<int[]> solution = new ArrayList<>();

        for (int id : map.keySet()) {
            int sum = 0;
            for (int i = 0; i < 5; ++i) sum += map.get(id).poll();
            solution.add(new int[] {id, sum / 5});
        }
        return solution.toArray(new int[solution.size()][]);
    }
}
