public class QuickSort {
    /*
     *快速排序在大部分时候的时间复杂度都是O(nlogn)，
     * 但是当数组为逆序排序时（假设每次以第一个元素为pivot），时间复杂度将会退化到O(n^2)
     */
    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSort(nums, 0, nums.length-1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start, right = end;
        // pivot is the value, not the index
        // pivot should not be nums[start] nor nums[end]
        int pivot = nums[(left + right) / 2];

        //partition
        while (left <= right) {
            while (left <= right && nums[left] < pivot)
                left++;
            while (left <= right && nums[right] > pivot)
                right--;
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        //after the while loop, left and right pointers have crossed, so left is larger than right
        // so the rest two parts are (start, right) and (left, end)
        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }
}
