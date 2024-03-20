class Easy_BestTimeBuyStocks {

    // 121. Best Time to Buy and Sell Stock

    /*
    * You are given an array prices where prices[i] is the price of a given stock on the ith day.
    * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the
    * future to sell that stock.
    *
    * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

     Input: prices = [7,1,5,3,6,4]
     Output: 5
     Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
         Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
    *
    * */
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {

        /*
         * The idea is to find days when we can hae max profit. For that we need to have:
         * minPrice - is a day when, the most profitable price to buy, because from the very beginning it's unknown
         * we think it as MAX_PRICE
         * profit - what we are looking for. Default is 0 from definition
         *
         * We iterate over the days and calculate:
         *  1. if the price on test day is lower than minPrice --> it's day to buy.
         *    otherwise --> it's a day to sell, so we need to calculate profit and compare with existing -->
         * That's ALL
         * */

        int profit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                // day to buy, because it's cheaper than before
                minPrice = prices[i];
            } else {
                // day to sell, because the price is higher than we have bought, time to calculate profit
                int tempProfit = prices[i] - minPrice;
                if (tempProfit > profit) {
                    profit = tempProfit;
                }
            }
        }

        return profit;

    }
}