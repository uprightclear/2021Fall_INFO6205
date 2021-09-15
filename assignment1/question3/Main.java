package question3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] example = {1,4,3,2};
        System.out.println(solution(example));
    }

    //Time Complexity: o(nlogn)
    //Space Complexity: o(logn) (o(logn) is the space complexity that quickSort uses)
    public static int solution(int[] nums) {
        quickSort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }
        return ans;
    }

    private static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length -1);
    }

    private static  void quickSort(int[] arr, int low, int high){

        if(low < high){
            int pos = partition (arr, low, high);
            quickSort(arr, low, pos -1);
            quickSort(arr, pos +1, high);
        }
    }

    private static  int partition(int[] arr, int low, int high){

        int pivot = arr[high];
        int wall = low -1;
        for(int i = low; i < high; i ++){
            if(arr[i] < pivot){
                wall ++;
                swap(arr, i, wall);
            }
        }

        wall ++;
        swap(arr, high, wall);
        return wall;
    }

    private static void swap(int[] arr, int i , int j){
        if(arr == null || i < 0 || i > arr.length -1 || j < 0 || j > arr.length -1){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
