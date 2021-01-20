public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int curSum = nums[0], maxSum = nums[0];

        for (int i = 1; i < n; i++){
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;

    }

    public static int printMaxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int length = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
                start = i;
            }
            sum += nums[i];
            if (max < sum) {
                end = i;
                length = end - start + 1;
                max = sum;
            }
        }
        for (int i = end + 1 - length; i <=end; i++){
            System.out.println(nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, -4, 5, 6, 7};
        printMaxSubArray(nums);
    }
}
