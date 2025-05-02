class Solution {
    public int maxProfit(int[] prices) {
        int bp=prices[0];
        int max_profit=0;
        
        int n=prices.length;
        for(int i=1;i<n;i++){
            if(bp<prices[i]){
                int profit=prices[i]-bp;
                max_profit=Math.max(profit,max_profit);
            }else{
            bp=prices[i];
            }
           
        }
        return max_profit;
    }
}