package TwoPointers;

import java.util.Arrays;

public class ValidTriangle {
    public int triangleNumber(int[] nums) {
        int left = 0, right = nums.length-1;
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i< nums.length; i++) {
            left = 0;
            right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    ans += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}
