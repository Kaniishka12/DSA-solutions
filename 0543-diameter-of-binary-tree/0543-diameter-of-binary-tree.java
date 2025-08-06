class Solution {
    private int maxDiameter = 0; // To track the maximum diameter

    public int diameterOfBinaryTree(TreeNode root) {
        height(root); // Calculate height and update maxDiameter
        return maxDiameter; // Return the maximum diameter found
    }

    private int height(TreeNode node){
        if(node==null){
            return 0;
        }
        int lh=height(node.left);
        int rh=height(node.right);
        maxDiameter=Math.max(maxDiameter,lh+rh);
        return 1+Math.max(lh,rh);




    }
}
