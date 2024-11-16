import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class TreeVisualizer extends JPanel {
    private List<TreeNode> trees; // List of BSTs to display
    private int currentTreeIndex = 0; // Track the current tree being displayed

    public TreeVisualizer(List<TreeNode> trees) {
        this.trees = trees;
        setPreferredSize(new Dimension(600, 400));
    }

    // Function to draw a single tree on the panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (trees != null && !trees.isEmpty()) {
            TreeNode root = trees.get(currentTreeIndex);
            drawTree(g, root, getWidth() / 2, 30, getWidth() / 4, 50);
        }
    }

    // Helper function to recursively draw the tree nodes
    private void drawTree(Graphics g, TreeNode node, int x, int y, int xOffset, int yOffset) {
        if (node == null)
            return;

        g.setColor(Color.BLACK);
        g.fillOval(x - 15, y - 15, 30, 30); // Draw the node as a circle
        g.setColor(Color.WHITE);
        g.drawString(Integer.toString(node.val), x - 5, y + 5); // Draw the value inside the node

        if (node.left != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x - 15, y, x - xOffset, y + yOffset); // Draw line to the left child
            drawTree(g, node.left, x - xOffset, y + yOffset, xOffset / 2, yOffset); // Recursively draw left child
        }

        if (node.right != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x + 15, y, x + xOffset, y + yOffset); // Draw line to the right child
            drawTree(g, node.right, x + xOffset, y + yOffset, xOffset / 2, yOffset); // Recursively draw right child
        }
    }

    // Function to move to the next tree
    public void showNextTree() {
        currentTreeIndex = (currentTreeIndex + 1) % trees.size();
        repaint();
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return generateSubtrees(1, n);
    }

    private static List<TreeNode> generateSubtrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = generateSubtrees(start, i - 1);
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, end);

            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 3; // Number of nodes in the BST

        // Generate all unique BSTs for the given n
        List<TreeNode> trees = generateTrees(n);

        // Create the main frame
        JFrame frame = new JFrame("BST Visualizer");
        TreeVisualizer visualizer = new TreeVisualizer(trees);
        frame.add(visualizer);

        // Button to show the next tree
        JButton nextButton = new JButton("Next Tree");
        nextButton.addActionListener(e -> visualizer.showNextTree());
        frame.add(nextButton, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
