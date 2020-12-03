public class FindPeakElement {
    /*
     Given an integer array nums, find a peak element, and return its index.
     If the array contains multiple peaks, return the index to any of the peaks.
     */
    public int findPeakElement(int[] nums) {
        //linear scan: O(n)
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] > nums[i+1])
                return i;
        }
        return nums.length -1;
    }

    //Recursive Binary Search: O(logN)
    public int findPeak(int[] nums) {
        return search(nums, 0, nums.length-1);
    }

    private int search(int[] nums, int left, int right) {
        if (left == right)
            return left;
        int mid = (left + right) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, left, mid);
        return search(nums, mid + 1, right);
    }

    //Iterative Binary Search
    public int findPeak2(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (A[mid] > A[mid + 1])
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}
