import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, 0, result);
        return result;
    }

    private void traverse(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return; // Base case: Stop when reaching a null node.

        // If this is the first time visiting this level, create a new list for it.
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }

        // Add the current node's value to its corresponding level list.
        result.get(level).add(node.val);

        // Recursively process left and right children, moving to the next level.
        traverse(node.left, level + 1, result);
        traverse(node.right, level + 1, result);
    }
}
