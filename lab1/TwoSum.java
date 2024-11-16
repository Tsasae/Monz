import java.io.*;
import java.util.*;

import lab3.Solution;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }

            numMap.put(nums[i], i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input1.txt"));
            String[] numStrs = reader.readLine().split(" ");
            int[] nums = new int[numStrs.length];

            for (int i = 0; i < numStrs.length; i++) {
                nums[i] = Integer.parseInt(numStrs[i]);
            }

            int target = Integer.parseInt(reader.readLine());
            reader.close();

            int[] result = solution.twoSum(nums, target);

            BufferedWriter writer = new BufferedWriter(new FileWriter("output1.txt"));
            if (result.length == 2) {
                writer.write(result[0] + " " + result[1]);
            } else {
                writer.write("Hariult oldsongui");
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sortedArrayToBST'");
    }
}
