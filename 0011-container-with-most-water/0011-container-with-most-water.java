class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int ma=0;
        while(l<r){
            int left=height[l];
            int right=height[r];
            int minh=Math.min(left,right);
            ma=Math.max(ma,minh*(r-l));
            if(left<right){
                l++;
            }else{
                r--;
            }
        }
return ma;
    }
}