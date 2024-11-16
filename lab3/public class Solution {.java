public class Solution {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {-10, -3, 0, 5, 9};
        int[] nums2 = {1, 3};
        TreeNode root1 = solution.sortedArrayToBST(nums1);
        TreeNode root2 = solution.sortedArrayToBST(nums2);
        
        // You can add code here to print the tree or verify the structure
    }
}
