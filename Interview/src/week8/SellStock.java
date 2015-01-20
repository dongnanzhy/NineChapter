package week8;

public class SellStock {
	
	/**
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * Design an algorithm to find the maximum profit. You may complete at most one transactions.
	 * @param prices
	 * @return
	 */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
        	return 0;
        }
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i : prices) {
        	min = i < min ? i : min;
        	profit = (i - min > profit) ? i - min: profit;
        }
        return profit;
    }
    
	/**
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * Design an algorithm to find the maximum profit. You may complete transactions any times.
	 * @param prices
	 * @return
	 */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
        	return 0;
        }
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
        	int dif = prices[i + 1] - prices[i];
        	if (dif > 0) {
        		profit += dif;
        	}
        }
        return profit;
    }
    
	/**
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
	 * @param prices
	 * @return
	 */
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
        	return 0;
        }
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        
        // the first most profit sell on day i
        int min = prices[0];
        left[0] = 0;
        for (int i = 1; i < left.length; i++) {
        	min = Math.min(prices[i], min);
        	left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        
        // the second most profit sell on day i
        int max = prices[prices.length - 1];
        right[prices.length - 1] = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
        	max = Math.max(prices[i], max);
        	right[i] = Math.max(right[i + 1], max - prices[i]);
        }
        
        // the largest profit
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
        	profit = Math.max(profit, left[i] + right[i]);
        }
        return profit;
    }
    
}
