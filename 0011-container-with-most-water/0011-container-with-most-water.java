class Solution {
    public int maxArea(int[] height) {
       int ma=0;
       int l=0;
       int r=height.length-1;
      while(l<r){
int lh=height[l];
int rh=height[r];
int minh=Math.min(lh,rh);
ma=Math.max(ma,(minh)*(r-l));
if(lh<rh){
    l++;
}else{
    r--;
}
 }
       return ma;
    }
}