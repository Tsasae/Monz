
import java.util.Scanner;

public class longestNiceSubstring1 {
    public String longestNiceSubstring(String s) {
        // If the string length is less than 2, no "nice" substring can exist.
        if (s.length() < 2) {
            return "";
        }

        // Convert the string to a character array for easy traversal.
        char[] chars = s.toCharArray();

        // Traverse through the characters to check for invalid splits.
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            // Check if both upper and lower case versions of the character exist.
            if (s.indexOf(Character.toLowerCase(c)) == -1 || s.indexOf(Character.toUpperCase(c)) == -1) {
                // If either is missing, split the string around this character.
                String leftSubstring = longestNiceSubstring(s.substring(0, i));
                String rightSubstring = longestNiceSubstring(s.substring(i + 1));

                // Return the longer of the two substrings.
                return leftSubstring.length() >= rightSubstring.length() ? leftSubstring : rightSubstring;
            }
        }

        return s;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();

        longestNiceSubstring1 solution = new longestNiceSubstring1();

        String result = solution.longestNiceSubstring(inputString);
        System.out.println("Longest nice substring: " + result);
    }
}
