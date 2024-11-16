import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Twosum1 {

    public static int[] twoSum(int[] nums, int target) {
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
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String[] numsLine = reader.readLine().split("=")[1].trim().replace("[", "").replace("]", "").split(",");
            int[] nums = new int[numsLine.length];
            for (int i = 0; i < numsLine.length; i++) {
                nums[i] = Integer.parseInt(numsLine[i].trim());
            }
            int target = Integer.parseInt(reader.readLine().split("=")[1].trim());
            reader.close();

            // Call the twoSum function
            int[] result = twoSum(nums, target);

            // Write output to file
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("Indices: [" + result[0] + ", " + result[1] + "]");
            writer.close();

            System.out.println("Result written to output.txt: Indices: [" + result[0] + ", " + result[1] + "]");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
