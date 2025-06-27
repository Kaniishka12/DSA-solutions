class Solution {
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        check(root);
        return isBalanced;
    }

    private int check(TreeNode node) {
        if (node == null) return 0;

        int left = check(node.left);
        int right = check(node.right);

        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }

        return Math.max(left, right) + 1;
    }
}
