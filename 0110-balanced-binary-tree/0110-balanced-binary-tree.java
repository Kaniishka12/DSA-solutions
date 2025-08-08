class Solution {
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        check(root);
        return isBalanced;
    }

    private int check(TreeNode node) {
     if(node==null){
        return 0;
     }
     int lh=check(node.left);
     int rh=check(node.right);

     if(Math.abs(rh-lh)>1){
        isBalanced=false;
     }
     return Math.max(lh,rh)+1;
    }
}
