package BinarySearchTree;

public class FindMinimumInRotatedSortedArray {
    //n == nums.length
    //1 <= n <= 5000
    // find the OOXX condition that the minimum element fit in
    public int findMin(int[] nums) {
        int n = nums.length;
        for (int i = n-2; i >= 0; i--) {
            if (!(nums[i] < nums[i+1]))
                return nums[i+1];
        }
        return nums[0];
    }
}
