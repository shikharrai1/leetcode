class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int [] mBP = new int[prices.length]; 
        for(int i=0; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            mBP[i] = min;
        }
        int maxProfit = Integer.MIN_VALUE;
        for(int i=0; i<prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i]-mBP[i]);
        }
        return maxProfit;
    }
}