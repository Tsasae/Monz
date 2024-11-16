import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complements = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer complementIndex = complements.get(nums[i]);
            if (complementIndex != null) {
                return new int[] { i, complementIndex };
            }
            complements.put(target - nums[i], i);
        }
        return nums;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTwoNumbers'");
    }

}