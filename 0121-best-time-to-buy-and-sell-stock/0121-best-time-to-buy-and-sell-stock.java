class Solution {
    public int maxProfit(int[] prices) {
       int bp=prices[0];
       int pr=0;
       int mp=0;
       for(int i=1;i<prices.length;i++){
        if(prices[i]>bp){
        pr=prices[i]-bp;
        mp=Math.max(pr,mp);
        }else{
            bp=prices[i];
        }
       }
       return mp;
    }
}