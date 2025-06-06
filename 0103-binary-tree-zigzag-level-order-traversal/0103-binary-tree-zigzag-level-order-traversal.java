/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();
        levelOrderHelper(root, 0, result);
        return result;
    }
    private void levelOrderHelper(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return;

        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
            result.get(level).add(node.val); // Left to Right
        } else {
            result.get(level).add(0, node.val); // Right to Left
        }

        levelOrderHelper(node.left, level + 1, result);
        levelOrderHelper(node.right, level + 1, result);
        
        
       
    }
}