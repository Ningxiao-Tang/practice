import java.util.ArrayList;

public class KthSmallestElementBST {
    // To solve the problem, one could use the property of BST :
    // inorder traversal of BST is an array sorted in the ascending order.
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        return arr.get(k-1);
    }

    private ArrayList<Integer> inorder(TreeNode node, ArrayList<Integer> arr) {
        if (node == null) {
            return null;
        }
        inorder(node.left, arr);
        arr.add(node.val);
        inorder(node.right, arr);
        return arr;
    }
}
