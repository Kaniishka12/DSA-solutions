class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int ma=0;
        int lm,rm;
        while(l<r){
            lm=height[l];
            rm=height[r];
            int mnh=Math.min(lm,rm);
            ma=Math.max(ma,mnh*(r-l));
            if(lm<rm){
                l++;
            }else{
                r--;
            }
        }
        return ma;

    }
}