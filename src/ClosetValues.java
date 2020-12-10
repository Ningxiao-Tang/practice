import java.util.LinkedList;

public class ClosetValues {

    public int closestValue(TreeNode root, double target) {
        // inorder traverse and searching for the closet value at the same time
        // stop just after identifying the closest value;
        // The closest value is found if the target value is in-between of two inorder array elements
        // nums[i] <= target < nums[i + 1]. Then the closest value is one of these elements.

        LinkedList<TreeNode> stack = new LinkedList();
        long val = Long.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();

            if (val <= target && target < root.val) {
                return Math.abs(val - target) < Math.abs(root.val - target) ? (int)val : root.val;
            }
            val = root.val;
            root = root.right;
        }
        //We're here because during the loop one couldn't identify the closest value.
        // That means that the closest value is the last value in the inorder traversal,
        // i.e. current predecessor value. Return it.
        return  (int) val;
    }
}
