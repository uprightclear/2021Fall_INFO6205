package question2_6;

public class Main {
    public static void main(String[] args) {
        int[][] example = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        System.out.println(countNegativeNum(example));
    }

    //Time Complexity: o(mlogn) (m: the length of rows  n: the length of columns)
    //Space Complexity: o(1)
    public static int countNegativeNum(int[][] grid) {
        int ans = 0, m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            int[] row = grid[i];
            //judge the last element of this row
            if(row[n - 1] >= 0) continue;
            if(row[0] < 0) {
                ans += (m - i) * n;
                break;
            }
            //find the 1st num smaller than 0
            int begin = binarySearch(row);
            ans += n - begin;
        }
        return ans;
    }

    public static int binarySearch(int[] arr) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= 0) l = mid + 1;
            else {
                if (arr[mid - 1] >= 0) return mid;
                r = mid;
            }
        }
        return l;
    }

}
