import javax.swing.*;
import java.awt.*;

public class TreeVisualizer extends JPanel {
    private TreeNode root;

    public TreeVisualizer(TreeNode root) {
        this.root = root;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (root != null) {
            drawTree(g, root, getWidth() / 2, 30, getWidth() / 4);
        }
    }

    private void drawTree(Graphics g, TreeNode node, int x, int y, int xOffset) {
        if (node == null) {
            return;
        }

        g.drawOval(x - 15, y - 15, 30, 30);
        g.drawString(Integer.toString(node.val), x - 10, y + 5);

        if (node.left != null) {
            g.drawLine(x - 10, y + 10, x - xOffset + 10, y + 50 - 10);
            drawTree(g, node.left, x - xOffset, y + 50, xOffset / 2);
        }

        if (node.right != null) {
            g.drawLine(x + 10, y + 10, x + xOffset - 10, y + 50 - 10);
            drawTree(g, node.right, x + xOffset, y + 50, xOffset / 2);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = solution.sortedArrayToBST(nums);

        JFrame frame = new JFrame("Binary Search Tree");
        TreeVisualizer treeVisualizer = new TreeVisualizer(root);
        frame.add(treeVisualizer);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
