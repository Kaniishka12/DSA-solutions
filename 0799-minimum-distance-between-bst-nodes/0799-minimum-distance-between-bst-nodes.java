class Solution {
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root,arr);
        int min =Integer.MAX_VALUE;
        for(int i=0;i<arr.size()-1;i++){

            int j =i+1;
            int diff = arr.get(j)-arr.get(i);
            min = Math.min(min,diff);
        }
        return min;

    }
    public static void inorder(TreeNode root,ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        inorder(root.left,arr);
        arr.add(root.val);
         inorder(root.right,arr);
    }
}