package Arrays.Medium;

public class StockBuyAndSell {
    // brute force approach
    // find every possible combination
    // time complexity : O(N^2)
    // space complexity : O(1)
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        int maxProfit = 0;
        for ( int i = 0; i < len; i++ ){
            int purchasePrice = prices[i];
            for( int j = i+1; j < len; j++ ){
                maxProfit = Math.max(maxProfit,  prices[j] - purchasePrice);
            }
        }
        return maxProfit;
    }

    // optimized approach
    // time complexity : O(N)
    // space complexity : O(1)
    public int maxProfit( int [] prices ){
        int purchasePrice = prices[0];
        int maxProfit = 0;
        int len = prices.length;
        for ( int i = 1; i < len; i++ ){
            if ( prices[i] < purchasePrice ){
                purchasePrice = prices[i];
            }else{
                maxProfit = Math.max(maxProfit, prices[i] - purchasePrice);
            }
        }
        return maxProfit;
    }
}
