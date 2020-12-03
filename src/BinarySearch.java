public class BinarySearch {
    public static int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        //return findPosition(nums, target);
        return find(nums, target, 0, nums.length-1);
    }

    private static int find(int[] nums, int target, int start, int end) {
        if (start > end ) return -1;
        int mid = (start + end)/2;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] < target)
            return find(nums, target, mid+1, end);

        return find(nums, target, start, mid-1);

    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,5};
        System.out.println(binarySearch(a, 6));
    }
}
