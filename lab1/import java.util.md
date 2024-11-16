import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
### Explanation:
1. **HashMap Initialization**: We initialize a HashMap to store the numbers and their indices.
2. **Iteration**: We iterate through the array.
3. **Complement Calculation**: For each number, we calculate its complement (i.e., `target - nums[i]`).
4. **Check and Return**: If the complement exists in the map, we return the indices of the complement and the current number.
5. **Update Map**: If the complement does not exist, we add the current number and its index to the map.

This approach ensures that we only pass through the array once, making the solution efficient with a time complexity of O(n).

Feel free to ask if you have any questions or need further clarification!

Source: Conversation with Copilot, 9/4/2024
(1) Two Sum - Leetcode Solution - CodingBroz. https://www.codingbroz.com/two-sum-leetcode-solution/.
(2) Two Sum Problem | Solution - Code Daily. https://codedaily.in/two-sum-problem-solution/.
(3) GitHub - AyazRao/Two-Sum: Given an array of integers nums and an .... https://github.com/AyazRao/Two-Sum.
(4) Two Sum - LeetCode. https://leetcode.com/problems/two-sum/.
(5) LeetCode Solution: 2 Sum Problem - Studytonight. https://www.studytonight.com/post/leetcode-solution-2-sum-problem.
(6) Add Two Numbers 2 - Leetcode Solution - CodingBroz. https://www.codingbroz.com/add-two-numbers-2-leetcode-solution/.
(7) Add Two Numbers - Leetcode Solution - CodingBroz. https://www.codingbroz.com/add-two-numbers-leetcode-solution/.
(8) github.com. https://github.com/hcf1/LearnProject/tree/985d6794c94fc872434aed2df45d78fcf9377bf0/leetcode%2Fsrc%2FTowSum1.java.
(9) github.com. https://github.com/xionghaiyang/bigdata/tree/ad8312dfb49ed58ad25abd1bffea125e1390a383/project_parent%2Falgorithm%2Fleetcode%2Fsrc%2Fmain%2Fjava%2Fcom%2Fsean%2Fleetcode%2FLeetCodeJava1_TwoSum.java.
(10) github.com. https://github.com/jjz921024/AlgoCode/tree/a589dcf041a6679683eb0dc2307a179938d44b63/src%2Fmain%2Fjava%2Falgo%2Fhashmap%2FNSum.java.
(11) github.com. https://github.com/zhanglekoon/Algorithm/tree/50610c7e37ab6ff280a37627c5c85079ba40ab54/README.md.