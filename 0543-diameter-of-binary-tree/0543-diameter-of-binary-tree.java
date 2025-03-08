class Solution {
    private int maxDiameter = 0; // To track the maximum diameter

    public int diameterOfBinaryTree(TreeNode root) {
        height(root); // Calculate height and update maxDiameter
        return maxDiameter; // Return the maximum diameter found
    }

    private int height(TreeNode node) {
        if (node == null) return 0; // Base case: height of null node is 0

        int leftHeight = height(node.left);  // Recursively get left subtree height
        int rightHeight = height(node.right); // Recursively get right subtree height

        // Update maxDiameter (edges between left and right subtrees)
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight); // Return height of current node
    }
}
