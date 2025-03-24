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
    private int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder, Integer.MAX_VALUE);
    }

    private TreeNode constructBST(int[] preorder, int upperBound) {
        if (index == preorder.length || preorder[index] > upperBound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index++]);
        
        root.left = constructBST(preorder, root.val);   // Left subtree must be < root.val
        root.right = constructBST(preorder, upperBound); // Right subtree must be < upperBound

        return root;
    }
}
