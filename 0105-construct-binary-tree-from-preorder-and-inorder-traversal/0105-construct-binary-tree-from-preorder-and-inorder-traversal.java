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
    HashMap<Integer,Integer> hm;
    int idx;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        hm=new HashMap<>();
        idx=0;
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length-1);



    }
    public TreeNode build(int[] preorder,int left,int right){
        if(left>right)return null;
        int rootValue=preorder[idx++];
        TreeNode root=new TreeNode(rootValue);
        int ri=hm.get(rootValue);
        root.left=build(preorder,left,ri-1);
        root.right=build(preorder,ri+1,right);
        return root;
    }
}