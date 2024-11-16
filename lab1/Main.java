import lab3.Solution;

public class Main {
    public static void main(String[] args) {
        String input1 = "2,4,3";
        String input2 = "5,6,4";

        ListNode l1 = ListNode.deserialize(input1);
        ListNode l2 = ListNode.deserialize(input2);

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result
        printList(result);
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }
}
