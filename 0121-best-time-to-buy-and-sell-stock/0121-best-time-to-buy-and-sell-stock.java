class Solution {
    public int maxProfit(int[] prices) {
        int bp=prices[0];
        int mp=0;
        int p=0;

        for(int i=1;i<prices.length;i++){
            if(bp<prices[i]){
                p=prices[i]-bp;
                mp=Math.max(mp,p);
            }else{
                bp=prices[i];
            }
        }
        return mp;
    }
}