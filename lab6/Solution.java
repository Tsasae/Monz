import java.util.Scanner;

public class Solution {
    public int numTrees(int n) {
        // Create a DP array to store the results
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 1;
        dp[1] = 1;

        // Fill the dp array for all values from 2 to n
        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                dp[nodes] += dp[root - 1] * dp[nodes - root];
            }
        }

        // The final result is stored in dp[n]
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        // Input any value of n
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        // Print the result
        System.out.println("Unique BSTs for n = " + n + ": " + solution.numTrees(n));

        // Close the scanner
        scanner.close();
    }
}
