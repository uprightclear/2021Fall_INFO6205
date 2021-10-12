package question5_8;

public class Main {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(search(new int[]{1}, 0));
    }

    //Time Complexity: o(logn)
    //Space Complexity: o(1)
    public static int search(int[] nums, int target) {
        int len = nums.length;
        //if(len == 0) return -1;
        if(len == 1) return nums[0] == target ? 0 : -1;

        int l = 0, r = len - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target) return mid;

            if(nums[0] <= nums[mid]){//left odered
                if(nums[0] <= target && target < nums[mid]){//in left
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{//right ordered
                if(nums[mid] < target && target <= nums[len - 1]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
