package TwoPointers;

import java.util.*;

public class CombinationSort {
    public static int twoSum6(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return 0;

        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int v = nums[left] + nums[right];
            if (v == target) {
                count ++;
                left ++;
                right --;
                while (left < right && nums[right] == nums[right + 1])
                    right --;
                while (left < right && nums[left] == nums[left - 1])
                    left ++;
            } else if (v > target) {
                right --;
            } else {
                left ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,45,46,46};
        int target = 47;
        System.out.println(twoSum6(a, target));
    }

}
