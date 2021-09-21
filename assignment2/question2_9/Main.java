package question2_9;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println(findKthPositive(arr, k));
    }

    //Time Complexity: o(logn)
    //Space Complexity: o(1)
    public static int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (arr[pivot] - pivot - 1 < k) left = pivot + 1;
            else {
                right = pivot - 1;
                System.out.println("right:" +right);
            }
        }

        // left = right + 1,
        // The number of integers missing before arr[right] is (arr[right] - right - 1)
        // There are still k - (arr[right] - right - 1) integers need to be added
        // So the result = arr[right] + (k - (arr[right] - right - 1)) = k + left
        return left + k;
    }
}
