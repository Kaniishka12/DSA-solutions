class Solution {
    private int maxDiameter = 0; // To track the maximum diameter

    public int diameterOfBinaryTree(TreeNode root) {
        height(root); 
        return maxDiameter;


    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        maxDiameter=Math.max(maxDiameter,lh+rh);
        return Math.max(lh,rh)+1;
    }
}
