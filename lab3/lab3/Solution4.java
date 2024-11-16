package lab3;

import javax.swing.tree.TreeNode;

public class Solution4 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return convertListToBST(nums, 0, nums.length - 1);
    }

    private TreeNode convertListToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = convertListToBST(nums, left, mid - 1);
        node.right = convertListToBST(nums, mid + 1, right);
        return node;
    }
}
