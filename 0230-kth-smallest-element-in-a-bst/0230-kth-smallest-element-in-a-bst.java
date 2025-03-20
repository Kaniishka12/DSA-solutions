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
    public int kthSmallest(TreeNode root, int k) {
         ArrayList<Integer> list = new ArrayList<>();
        inorderTraversal(root, list); // Convert tree to sorted list
        
        Collections.sort(list); // Sort the list (needed if tree is NOT a BST)

        return list.get(k - 1); // k is 1-based index, so get (k-1)
    }
     public static void inorderTraversal(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

}