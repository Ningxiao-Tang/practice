package BinarySearchTree;

public class MinimumSubtree {
    public TreeNode findSubtree(TreeNode root) {
        TreeNode[] result = new TreeNode[1];
        int[] min_sum = {Integer.MAX_VALUE};
        getSubtreeSum(root, result, min_sum);
        return result[0];
    }

    private int getSubtreeSum(TreeNode root, TreeNode[] result, int[] min_sum) {
        if (root == null) {
            return 0;
        }
        int leftSum = getSubtreeSum(root.left, result, min_sum);
        int rightSum = getSubtreeSum(root.right, result, min_sum);
        int sum = leftSum + rightSum + root.val;

        if (sum < min_sum[0]) {
            min_sum[0] = sum;
            result[0] = root;
        }

        return sum;
    }
}
