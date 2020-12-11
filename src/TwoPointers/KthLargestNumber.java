package TwoPointers;

public class KthLargestNumber {
    // quick select algorithm
    public int kthLargestElement(int n, int[] nums) {
        if (nums == null)
            return -1;
        return quickSelect(nums, 0, nums.length - 1, n);
    }

    private int quickSelect(int[] nums, int lo, int hi, int n) {
        if (lo == hi)
            return nums[lo];

        int i = lo, j = hi;
        int pivot = nums[(lo+hi)/2];
        // sort elements in descending order
        while (i <= j) {
            while (i <= j && nums[i] > pivot)
                i++;
            while (i <= j && nums[j] < pivot)
                j--;
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }// after partion, i is larger than or equals to j,
        // which divides the array into three part:(lo,j); (j,i); (i,hi)
        // when selecting the nth element, n-1 is the offset from lo

        if (lo + n - 1 <= j)
            return quickSelect(nums, lo, j, n);
        if (lo + n - 1 >= i)
            return quickSelect(nums, i, hi, n-(i-lo));

        return nums[j+1];

    }
}
