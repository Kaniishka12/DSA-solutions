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
    public int maxDepth(TreeNode root) {
        ArrayList<ArrayList<Integer>> res=new ArrayList();
        traverse(root,0,res);
        return res.size();
    }
    public void traverse(TreeNode root,int level,ArrayList<ArrayList<Integer>> res){
        if(root==null){
            return;
        }
        if(res.size()==level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        traverse(root.left,level+1,res);
        traverse(root.right,level+1,res);
    }
}